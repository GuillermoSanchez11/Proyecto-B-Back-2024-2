package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.dto.impl.BookingRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ILuggageRequestDTO;
import com.codefactory.reserva_b.dto.interfaces.IPassengerRequestDTO;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.*;
import com.codefactory.reserva_b.util.impl.SqlSentencesImpl;
import com.codefactory.reserva_b.util.interfaces.ISqlSentences;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements IBookingRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    private final ISqlSentences sentences = new SqlSentencesImpl();

    @Transactional
    @Override
    public List<BookingEntityImpl> findAllBookings() {
        List<BookingEntityImpl> bookings = entityManager.createNativeQuery(sentences.selectAllBookingsSentence(), BookingEntityImpl.class)
                .getResultList();
        return bookings;
    }

    @Transactional
    @Override
    public List<BookingEntityImpl> findBookingsByIdUser(BigInteger idUser) {
        List<BookingEntityImpl> bookings = entityManager.createNativeQuery(sentences.selectBookingByIdUserSentence(), BookingEntityImpl.class)
                .setParameter(1, idUser)
                .getResultList();
        return bookings;
    }

    @Transactional
    @Override
    public BookingEntityImpl findBookingByIdBooking(BigInteger idBooking) {
        BookingEntityImpl booking = (BookingEntityImpl) entityManager.createNativeQuery(sentences.selectBookingByIdBookingSentence(), BookingEntityImpl.class)
                .setParameter(1, idBooking)
                .getSingleResult();
        return booking;
    }

    @Transactional
    @Override
    public BookingEntityImpl createBooking(BookingRequestDTOImpl booking) {
        Long bookingId = (Long) entityManager.createNativeQuery(sentences.insertBookingSentence())
                .setParameter(1, booking.getIdFlight())
                .setParameter(2, booking.getIdUser())
                .setParameter(3, LocalDateTime.now())
                .setParameter(4, booking.getBookingStatus())
                .getSingleResult();

        if (booking.getPassengers() != null && !booking.getPassengers().isEmpty()) {
            for (IPassengerRequestDTO passenger : booking.getPassengers()) {
                Long passengerId = (Long) entityManager.createNativeQuery(sentences.insertPassengerSentence())
                        .setParameter(1, passenger.getIdSeat())
                        .setParameter(2, passenger.getFirstName())
                        .setParameter(3, passenger.getLastName())
                        .setParameter(4, LocalDate.parse(passenger.getDateOfBirth()))
                        .setParameter(5, passenger.getDocumentId())
                        .setParameter(6, passenger.getPassportNumber())
                        .setParameter(7, passenger.getNationality())
                        .setParameter(8, passenger.getSpecialRequests())
                        .setParameter(9, passenger.getLuggageIncluded())
                        .getSingleResult();
                entityManager.createNativeQuery(sentences.insertBookingPassengerSentence())
                        .setParameter(1, bookingId)
                        .setParameter(2, passengerId)
                        .executeUpdate();
                entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                        .setParameter(1, true)
                        .setParameter(2, passenger.getIdSeat())
                        .executeUpdate();
                if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
                    for (ILuggageRequestDTO luggage : passenger.getLuggage()) {
                        LuggageEntityImpl newLuggage = (LuggageEntityImpl) entityManager.createNativeQuery(sentences.insertLuggageSentence(), LuggageEntityImpl.class)
                                .setParameter(1, passengerId)
                                .setParameter(2, luggage.getType())
                                .setParameter(3, luggage.getHeightCm())
                                .setParameter(4, luggage.getWeightKg())
                                .setParameter(5, luggage.getWidthCm())
                                .setParameter(6, luggage.getExtraFree())
                                .getSingleResult();
                    }
                }
            }
        }
        return findBookingByIdBooking(new BigInteger(String.valueOf(bookingId)));
    }

    @Transactional
    @Override
    public List<BookingEntityImpl> deleteBooking(BigInteger idBooking) {
        BookingEntityImpl booking = findBookingByIdBooking(idBooking);
        if (booking == null) {
            throw new EntityNotFoundException("Booking not found with id: " + idBooking);
        }
        List<Long> passengerIds = entityManager.createNativeQuery(sentences.selectIdPassengersByIdBookingSentence())
                .setParameter(1, booking.getIdBooking())
                .getResultList();
        if (!passengerIds.isEmpty()) {
            for (Long passengerId : passengerIds) {
                Long seatId = (Long) entityManager.createNativeQuery(sentences.selectIdSeatFromIdPassenger())
                        .setParameter(1, passengerId)
                        .getSingleResult();
                entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                        .setParameter(1, false)
                        .setParameter(2, seatId)
                        .executeUpdate();
                entityManager.createNativeQuery(sentences.deleteLuggageSentence())
                        .setParameter(1, passengerId)
                        .executeUpdate();
                entityManager.createNativeQuery(sentences.deletePassengerSentence())
                        .setParameter(1, passengerId)
                        .executeUpdate();
            }
        }
        entityManager.createNativeQuery(sentences.deleteBookingPassengerSentence())
                .setParameter(1, idBooking)
                .executeUpdate();
        entityManager.createNativeQuery(sentences.deleteBookingSentence())
                .setParameter(1, idBooking)
                .executeUpdate();
        return findAllBookings();
    }

    @Transactional
    @Override
    public BookingEntityImpl editBookingStatus(String bookingStatus, BigInteger idBooking) {
        int updatedRows = entityManager.createNativeQuery(sentences.updateBookingStatusSentence())
                .setParameter(1, bookingStatus)
                .setParameter(2, idBooking)
                .executeUpdate();
        if (updatedRows == 0) {
            throw new EntityNotFoundException("Booking not found with id: " + idBooking);
        }
        return findBookingByIdBooking(idBooking);
    }
}

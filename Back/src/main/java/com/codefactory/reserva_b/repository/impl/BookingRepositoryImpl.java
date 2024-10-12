package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements IBookingRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<BookingEntityImpl> findAllBookings() {
        TypedQuery<BookingEntityImpl> query = entityManager.createQuery("SELECT b FROM BookingEntityImpl b", BookingEntityImpl.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<BookingEntityImpl> findBookingsByIdUser(BigInteger idUser) {
        TypedQuery<BookingEntityImpl> query = entityManager.createQuery(
                "SELECT b FROM BookingEntityImpl b WHERE b.idUser = :idUser", BookingEntityImpl.class);
        query.setParameter("idUser", idUser);
        return query.getResultList();
    }

    @Transactional
    @Override
    public BookingEntityImpl findBookingByIdBooking(BigInteger bookingId) {
        TypedQuery<BookingEntityImpl> query = entityManager.createQuery(
                "SELECT b FROM BookingEntityImpl b WHERE b.idBooking = :idBooking", BookingEntityImpl.class);
        query.setParameter("idBooking", bookingId);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public BookingEntityImpl createBooking(BookingEntityImpl booking) {
        entityManager.persist(booking);
        if (booking.getPassengers() != null && !booking.getPassengers().isEmpty()) {
            for (PassengerEntityImpl passenger : booking.getPassengers()) {
                entityManager.persist(passenger);
                entityManager.createNativeQuery("INSERT INTO booking_passenger (id_booking, id_passenger) VALUES (?, ?)")
                        .setParameter(1, booking.getIdBooking())
                        .setParameter(2, passenger.getIdPassenger())
                        .executeUpdate();
                entityManager.createNativeQuery("UPDATE seat SET is_reserved = true WHERE id_seat = ?")
                        .setParameter(1, passenger.getIdSeat())
                        .executeUpdate();
                if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
                    for (LuggageEntityImpl luggage : passenger.getLuggage()) {
                        entityManager.createNativeQuery("INSERT INTO luggage (id_passenger, type, height_cm, weight_kg, width_cm, extra_free) " +
                                        "VALUES (?, ?, ?, ?, ?, ?)")
                                .setParameter(1, passenger.getIdPassenger())
                                .setParameter(2, luggage.getType())
                                .setParameter(3, luggage.getHeightCm())
                                .setParameter(4, luggage.getWeightKg())
                                .setParameter(5, luggage.getWidthCm())
                                .setParameter(6, luggage.getExtraFree())
                                .executeUpdate();
                    }
                }
            }
        }
        return booking;
    }

    @Transactional
    @Override
    public List<BookingEntityImpl> deleteBooking(String idBooking) {
        BookingEntityImpl booking = entityManager.find(BookingEntityImpl.class, Long.valueOf(idBooking));
        if (booking == null) {
            throw new EntityNotFoundException("Booking not found with id: " + idBooking);
        }
        List<Long> passengerIds = entityManager.createNativeQuery("SELECT id_passenger FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .getResultList();
        if (!passengerIds.isEmpty()) {
            for (Long passengerId : passengerIds) {
                Long seatId = (Long) entityManager.createNativeQuery("SELECT id_seat FROM passenger WHERE id_passenger = ?")
                        .setParameter(1, passengerId)
                        .getSingleResult();
                entityManager.createNativeQuery("UPDATE seat SET is_reserved = false WHERE id_seat = ?")
                        .setParameter(1, seatId)
                        .executeUpdate();
                entityManager.createNativeQuery("DELETE FROM luggage WHERE id_passenger = ?")
                        .setParameter(1, passengerId)
                        .executeUpdate();
                entityManager.createNativeQuery("DELETE FROM passenger WHERE id_passenger = ?")
                        .setParameter(1, passengerId)
                        .executeUpdate();
            }
        }
        entityManager.createNativeQuery("DELETE FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .executeUpdate();
        entityManager.createNativeQuery("DELETE FROM booking WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .executeUpdate();

        return findAllBookings();
    }

    @Transactional
    @Override
    public BookingEntityImpl editBookingStatus(String bookingStatus, String idBooking) {
        long bookingId = Long.parseLong(idBooking);
        int updatedRows = entityManager.createNativeQuery("UPDATE booking SET booking_status = ? WHERE id_booking = ?")
                .setParameter(1, bookingStatus)
                .setParameter(2, bookingId)
                .executeUpdate();
        if (updatedRows == 0) {
            throw new EntityNotFoundException("Booking not found with id: " + idBooking);
        }
        return findBookingByIdBooking(BigInteger.valueOf(bookingId));
    }
}

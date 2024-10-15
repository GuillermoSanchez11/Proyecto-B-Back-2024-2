package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ILuggageRequestDTO;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.repository.interfaces.IPassengerRepository;
import com.codefactory.reserva_b.util.impl.SqlSentencesImpl;
import com.codefactory.reserva_b.util.interfaces.ISqlSentences;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PassengerRepositoryImpl implements IPassengerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final ISqlSentences sentences = new SqlSentencesImpl();

    @Transactional
    @Override
    public PassengerEntityImpl findPassengerByIdPassenger(BigInteger idPassenger) {
        PassengerEntityImpl passenger = (PassengerEntityImpl) entityManager.createNativeQuery(sentences.selectPassengerByIdPassengerSentence(), PassengerEntityImpl.class)
                .setParameter(1, idPassenger)
                .getSingleResult();
        return passenger;
    }

    @Transactional
    @Override
    public List<PassengerEntityImpl> findPassengersByIdBooking(BigInteger idBooking) {
        List<Long> passengerIds = entityManager.createNativeQuery(sentences.selectPassengerByIdBookingSentence())
                .setParameter(1, idBooking)
                .getResultList();
        if (passengerIds.isEmpty()) {
            return List.of();
        }
        List<PassengerEntityImpl> passengers = new ArrayList<>();
        for (Long passengerId : passengerIds) {
            PassengerEntityImpl passenger = (PassengerEntityImpl) entityManager.createNativeQuery(
                            sentences.selectPassengerByIdPassengerSentence(), PassengerEntityImpl.class)
                    .setParameter(1, passengerId)
                    .getSingleResult();
            passengers.add(passenger);
        }
        return passengers;
    }

    @Transactional
    @Override
    public PassengerEntityImpl createPassenger(PassengerRequestDTOImpl passenger, BigInteger idBooking) {
        Long idPassenger = (Long) entityManager.createNativeQuery(
                        sentences.insertPassengerSentence())
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
                .setParameter(1, idBooking)
                .setParameter(2, idPassenger)
                .executeUpdate();
        entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                .setParameter(1, true)
                .setParameter(2, passenger.getIdSeat())
                .executeUpdate();
        if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
            for (ILuggageRequestDTO luggage : passenger.getLuggage()) {
                entityManager.createNativeQuery(
                                sentences.insertLuggageSentence())
                        .setParameter(1, idPassenger)
                        .setParameter(2, luggage.getType())
                        .setParameter(3, luggage.getHeightCm())
                        .setParameter(4, luggage.getWeightKg())
                        .setParameter(5, luggage.getWidthCm())
                        .setParameter(6, luggage.getExtraFree())
                        .executeUpdate();
            }
        }
        return findPassengerByIdPassenger(new BigInteger(String.valueOf(idPassenger)));
    }

    @Transactional
    @Override
    public BookingEntityImpl deletePassenger(BigInteger idPassenger, BigInteger idBooking) {
        entityManager.createNativeQuery(sentences.deleteBookingPassengerSentence())
                .setParameter(1, idBooking)
                .setParameter(2, idPassenger)
                .executeUpdate();
        Long idSeat = (Long) entityManager.createNativeQuery(sentences.selectIdSeatFromIdPassenger())
                .setParameter(1, idPassenger)
                .getSingleResult();
        entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                .setParameter(1, false)
                .setParameter(2, idSeat)
                .executeUpdate();
        entityManager.createNativeQuery(sentences.deleteLuggageSentence())
                .setParameter(1, idPassenger)
                .executeUpdate();
        entityManager.createNativeQuery(sentences.deletePassengerSentence())
                .setParameter(1, idPassenger)
                .executeUpdate();
        BookingEntityImpl booking = (BookingEntityImpl) entityManager.createNativeQuery(sentences.selectBookingByIdBookingSentence(), BookingEntityImpl.class)
                .setParameter(1, idBooking)
                .getSingleResult();
        return booking;
    }

    @Transactional
    @Override
    public PassengerEntityImpl editPassengerSeat(BigInteger idPassenger, BigInteger idSeat) {
        PassengerEntityImpl passenger = findPassengerByIdPassenger(idPassenger);
        entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                .setParameter(1, false)
                .setParameter(2, passenger.getIdSeat())
                .executeUpdate();
        entityManager.createNativeQuery(sentences.updateIsReservedSentence())
                .setParameter(1, true)
                .setParameter(2, idSeat)
                .executeUpdate();
        entityManager.createNativeQuery(sentences.updatePassengerIdSeatSentence())
                .setParameter(1, idSeat)
                .setParameter(2, idPassenger)
                .executeUpdate();
        return findPassengerByIdPassenger(idPassenger);
    }

    @Transactional
    @Override
    public PassengerEntityImpl editPassengerInfo(BigInteger idPassenger, PassengerRequestDTOImpl passenger) {
        entityManager.createNativeQuery(sentences.updatePassengerInfoSentence())
                .setParameter(1, passenger.getFirstName())
                .setParameter(2, passenger.getLastName())
                .setParameter(3, LocalDate.parse(passenger.getDateOfBirth()))
                .setParameter(4, passenger.getDocumentId())
                .setParameter(5, passenger.getPassportNumber())
                .setParameter(6, passenger.getNationality())
                .setParameter(7, passenger.getSpecialRequests())
                .setParameter(8, idPassenger)
                .executeUpdate();
        return findPassengerByIdPassenger(idPassenger);
    }
}

package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IPassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl {
    @Autowired
    private IPassengerRepository passengerRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public PassengerEntityImpl getPassengerById(String id) {
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(id));
    }

    @Transactional
    public List<PassengerEntityImpl> getPassengersByBookingId(String idBooking) {
        List<Long> passengerIds = entityManager.createNativeQuery("SELECT id_passenger FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .getResultList();

        List<PassengerEntityImpl> passengers = new ArrayList<>();

        for (Long passengerId : passengerIds) {
            PassengerEntityImpl passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(passengerId.toString()));
            passengers.add(passenger);
        }

        return passengers;
    }

    @Transactional
    public PassengerEntityImpl editPassengerSeat(String idPassenger, String newIdSeat) {
        PassengerEntityImpl passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
        entityManager.createNativeQuery("UPDATE seat SET is_reserved = false WHERE id_seat = ?")
                .setParameter(1, passenger.getIdSeat())
                .executeUpdate();
        entityManager.createNativeQuery("UPDATE seat SET is_reserved = true WHERE id_seat = ?")
                .setParameter(1, Long.parseLong(newIdSeat))
                .executeUpdate();
        entityManager.createNativeQuery("UPDATE passenger SET id_seat = ? WHERE id_passenger = ?")
                .setParameter(1, Long.parseLong(newIdSeat))
                .setParameter(2, Long.parseLong(idPassenger))
                .executeUpdate();
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
    }

    @Transactional
    public PassengerEntityImpl editPassengerInfo(PassengerEntityImpl passenger) {
        entityManager.createNativeQuery("UPDATE passenger SET first_name = ?, last_name = ?, date_of_birth = ?, document_id = ?, passport_number = ?, nationality = ?, special_requests = ? WHERE id_passenger = ?")
                .setParameter(1, passenger.getFirstName())
                .setParameter(2, passenger.getLastName())
                .setParameter(3, passenger.getDateOfBirth())
                .setParameter(4, passenger.getDocumentId())
                .setParameter(5, passenger.getPassportNumber())
                .setParameter(6, passenger.getNationality())
                .setParameter(7, passenger.getSpecialRequests())
                .setParameter(8, passenger.getIdPassenger())
                .executeUpdate();
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(passenger.getIdPassenger().toString()));
    }
    
    @Transactional
    public PassengerEntityImpl editPassengerLuggage(String idLuggage, LuggageEntityImpl luggage){
        entityManager.createNativeQuery("UPDATE luggage SET type = ?, height_cm = ?, weight_kg = ?, width_cm = ?, extra_free = ? WHERE id_luggage = ?")
                .setParameter(1, luggage.getType())
                .setParameter(2, luggage.getHeightCm())
                .setParameter(3, luggage.getWeightKg())
                .setParameter(4, luggage.getWidthCm())
                .setParameter(5, luggage.getExtraFree())
                .setParameter(6, Long.parseLong(idLuggage))
                .executeUpdate();
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(luggage.getIdPassenger().toString()));
    }

    @Transactional
    public PassengerEntityImpl addLuggage(String idPassenger, LuggageEntityImpl luggage) {
        PassengerEntityImpl passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
        if(passenger.getLuggageIncluded().equals(Boolean.FALSE)){
            entityManager.createNativeQuery("UPDATE passenger SET luggage_included = true WHERE id_passenger = ?")
                    .setParameter(1, Long.parseLong(idPassenger))
                    .executeUpdate();
        }
        entityManager.createNativeQuery("INSERT INTO luggage (id_passenger, type, height_cm, weight_kg, width_cm, extra_free) " +
                        "VALUES (?, ?, ?, ?, ?, ?)")
                .setParameter(1, Long.parseLong(idPassenger))
                .setParameter(2, luggage.getType())
                .setParameter(3, luggage.getHeightCm())
                .setParameter(4, luggage.getWeightKg())
                .setParameter(5, luggage.getWidthCm())
                .setParameter(6, luggage.getExtraFree())
                .executeUpdate();
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
    }

    @Transactional
    public PassengerEntityImpl deleteLuggage(String idPassenger, String idLuggage){
        List<LuggageEntityImpl> luggageIds = entityManager.createNativeQuery("SELECT id_luggage FROM luggage WHERE id_passenger = ?")
                .setParameter(1, Long.valueOf(idPassenger))
                .getResultList();
        if(luggageIds.isEmpty() || luggageIds.size() == 1){
            entityManager.createNativeQuery("UPDATE passenger SET luggage_included = false WHERE id_passenger = ?")
                    .setParameter(1, Long.parseLong(idPassenger))
                    .executeUpdate();
        }
        entityManager.createNativeQuery("DELETE FROM luggage WHERE id_luggage = ?")
                .setParameter(1, Long.parseLong(idLuggage))
                .executeUpdate();

        return passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
    }
    /*@Transactional
    public BookingEntityImpl addPassenger(PassengerEntityImpl passenger, String idBooking) {
        Long passengerId = (Long) entityManager.createNativeQuery("INSERT INTO passenger (id_seat, first_name, last_name, date_of_birth, document_id, passport_number, nationality, special_requests, luggage_included) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_passenger")
                .setParameter(1, passenger.getIdSeat())
                .setParameter(2, passenger.getFirstName())
                .setParameter(3, passenger.getLastName())
                .setParameter(4, passenger.getDateOfBirth())
                .setParameter(5, passenger.getDocumentId())
                .setParameter(6, passenger.getPassportNumber())
                .setParameter(7, passenger.getNationality())
                .setParameter(8, passenger.getSpecialRequests())
                .setParameter(9, passenger.getLuggageIncluded())
                .getSingleResult();

        entityManager.createNativeQuery("INSERT INTO booking_passenger (id_booking, id_passenger) " +
                        "VALUES (?, ?)")
                .setParameter(1, Long.parseLong(idBooking))
                .setParameter(2, passengerId)
                .executeUpdate();

        entityManager.createNativeQuery("UPDATE seat SET is_reserved = true WHERE id_seat = ?")
                .setParameter(1, passenger.getIdSeat())
                .executeUpdate();

        if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
            for (LuggageEntityImpl luggage : passenger.getLuggage()) {
                entityManager.createNativeQuery("INSERT INTO luggage (id_passenger, type, height_cm, weight_kg, width_cm, extra_free) " +
                                "VALUES (?, ?, ?, ?, ?, ?)")
                        .setParameter(1, passengerId)
                        .setParameter(2, luggage.getType())
                        .setParameter(3, luggage.getHeightCm())
                        .setParameter(4, luggage.getWeightKg())
                        .setParameter(5, luggage.getWidthCm())
                        .setParameter(6, luggage.getExtraFree())
                        .executeUpdate();
            }
        }

        return bookingRepository.findBookingByIdBooking(new BigInteger(idBooking));
    }

    @Transactional
    public BookingEntityImpl deletePassenger(String idPassenger, String idBooking) {
        entityManager.createNativeQuery("DELETE FROM booking_passenger WHERE id_booking = ? AND id_passenger = ?")
                .setParameter(1, Long.parseLong(idBooking))
                .setParameter(2, Long.parseLong(idPassenger))
                .executeUpdate();

        Long seatId = (Long) entityManager.createNativeQuery("SELECT id_seat FROM passenger WHERE id_passenger = ?")
                .setParameter(1, Long.parseLong(idPassenger))
                .getSingleResult();

        entityManager.createNativeQuery("UPDATE seat SET is_reserved = false WHERE id_seat = ?")
                .setParameter(1, seatId)
                .executeUpdate();

        entityManager.createNativeQuery("DELETE FROM luggage WHERE id_passenger = ?")
                .setParameter(1, Long.parseLong(idPassenger))
                .executeUpdate();

        entityManager.createNativeQuery("DELETE FROM passenger WHERE id_passenger = ?")
                .setParameter(1, Long.parseLong(idPassenger))
                .executeUpdate();

        return bookingRepository.findBookingByIdBooking(new BigInteger(idBooking));
    }*/
}

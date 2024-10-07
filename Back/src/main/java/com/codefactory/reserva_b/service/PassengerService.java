package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Flight;
import com.codefactory.reserva_b.model.Luggage;
import com.codefactory.reserva_b.model.Passenger;
import com.codefactory.reserva_b.repository.FlightRepository;
import com.codefactory.reserva_b.repository.PassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public Passenger getPassengerById(String id) {
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(id));
    }

    @Transactional
    public List<Passenger> getPassengersByBookingId(String idBooking) {
        List<Long> passengerIds = entityManager.createNativeQuery("SELECT id_passenger FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .getResultList();

        List<Passenger> passengers = new ArrayList<>();

        for (Long passengerId : passengerIds) {
            Passenger passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(passengerId.toString()));
            passengers.add(passenger);
        }

        return passengers;
    }

    @Transactional
    public Passenger editPassengerSeat(String idPassenger, String newIdSeat) {
        Passenger passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
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
    public Passenger editPassengerInfo(Passenger passenger) {
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
    public Passenger editPassengerLuggage(String idLuggage, Luggage luggage){
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
    public Passenger addLuggage(String idPassenger, Luggage luggage) {
        Passenger passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
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
    public Passenger deleteLuggage(String idPassenger, String idLuggage){
        List<Luggage> luggageIds = entityManager.createNativeQuery("SELECT id_luggage FROM luggage WHERE id_passenger = ?")
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
}

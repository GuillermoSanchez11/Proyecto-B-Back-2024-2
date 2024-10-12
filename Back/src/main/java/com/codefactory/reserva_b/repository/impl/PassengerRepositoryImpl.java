package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.repository.interfaces.IPassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public class PassengerRepositoryImpl implements IPassengerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final IBookingRepository bookingRepository;

    public PassengerRepositoryImpl(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    @Override
    public PassengerEntityImpl findPassengerByIdPassenger(BigInteger idPassenger) {
        return entityManager.createQuery(
                        "SELECT p FROM PassengerEntityImpl p WHERE p.idPassenger = :idPassenger",
                        PassengerEntityImpl.class)
                .setParameter("idPassenger", idPassenger)
                .getSingleResult();
    }

    @Transactional
    @Override
    public List<PassengerEntityImpl> findPassengersByIdBooking(BigInteger idBooking) {
        // Obtener IDs de los pasajeros relacionados con el booking usando una consulta nativa
        List<BigInteger> passengerIds = entityManager.createNativeQuery(
                        "SELECT id_passenger FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, idBooking)
                .getResultList();

        // Si no hay pasajeros, retornar una lista vacía
        if (passengerIds.isEmpty()) {
            return List.of();
        }

        // Consulta JPQL para obtener los pasajeros correspondientes
        return entityManager.createQuery(
                        "SELECT p FROM PassengerEntityImpl p WHERE p.idPassenger IN :passengerIds",
                        PassengerEntityImpl.class)
                .setParameter("passengerIds", passengerIds)
                .getResultList();
    }

    @Transactional
    @Override
    public PassengerEntityImpl addPassenger(PassengerEntityImpl passenger, BigInteger idBooking) {
        // Insertar pasajero y obtener su ID
        BigInteger passengerId = (BigInteger) entityManager.createNativeQuery(
                        "INSERT INTO passenger (id_seat, first_name, last_name, date_of_birth, document_id, passport_number, nationality, special_requests, luggage_included) " +
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

        // Insertar relación en booking_passenger
        entityManager.createNativeQuery("INSERT INTO booking_passenger (id_booking, id_passenger) VALUES (?, ?)")
                .setParameter(1, idBooking)
                .setParameter(2, passengerId)
                .executeUpdate();

        // Actualizar el estado del asiento a reservado
        entityManager.createQuery(
                        "UPDATE SeatEntityImpl s SET s.isReserved = true WHERE s.idSeat = :idSeat")
                .setParameter("idSeat", passenger.getIdSeat())
                .executeUpdate();

        // Añadir equipaje si es necesario
        if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
            for (LuggageEntityImpl luggage : passenger.getLuggage()) {
                entityManager.createQuery(
                                "INSERT INTO LuggageEntityImpl (idPassenger, type, heightCm, weightKg, widthCm, extraFree) " +
                                        "VALUES (:passenger, :type, :heightCm, :weightKg, :widthCm, :extraFree)")
                        .setParameter("passenger", passengerId)
                        .setParameter("type", luggage.getType())
                        .setParameter("heightCm", luggage.getHeightCm())
                        .setParameter("weightKg", luggage.getWeightKg())
                        .setParameter("widthCm", luggage.getWidthCm())
                        .setParameter("extraFree", luggage.getExtraFree())
                        .executeUpdate();
            }
        }

        return findPassengerByIdPassenger(passengerId);
    }

    @Transactional
    @Override
    public BookingEntityImpl deletePassenger(BigInteger idPassenger, BigInteger idBooking) {
        // Eliminar relación de booking_passenger
        entityManager.createNativeQuery("DELETE FROM booking_passenger WHERE id_booking = ? AND id_passenger = ?")
                .setParameter(1, idBooking)
                .setParameter(2, idPassenger)
                .executeUpdate();

        // Obtener el ID del asiento del pasajero
        BigInteger seatId = (BigInteger) entityManager.createNativeQuery("SELECT id_seat FROM passenger WHERE id_passenger = ?")
                .setParameter(1, idPassenger)
                .getSingleResult();

        // Liberar el asiento
        entityManager.createQuery("UPDATE SeatEntityImpl s SET s.isReserved = false WHERE s.idSeat = :idSeat")
                .setParameter("idSeat", seatId)
                .executeUpdate();

        // Eliminar el equipaje del pasajero
        entityManager.createQuery("DELETE FROM LuggageEntityImpl l WHERE l.idPassenger = :idPassenger")
                .setParameter("idPassenger", idPassenger)
                .executeUpdate();

        // Eliminar el pasajero
        entityManager.createQuery("DELETE FROM PassengerEntityImpl p WHERE p.idPassenger = :idPassenger")
                .setParameter("idPassenger", idPassenger)
                .executeUpdate();

        return bookingRepository.findBookingByIdBooking(idBooking);
    }

    @Transactional
    @Override
    public PassengerEntityImpl editPassengerSeat(BigInteger idPassenger, BigInteger idSeat, BigInteger idBooking) {
        // Obtener el pasajero
        PassengerEntityImpl passenger = findPassengerByIdPassenger(idPassenger);

        // Liberar el asiento actual
        entityManager.createQuery("UPDATE SeatEntityImpl s SET s.isReserved = false WHERE s.idSeat = :idSeat")
                .setParameter("idSeat", passenger.getIdSeat())
                .executeUpdate();

        // Reservar el nuevo asiento
        entityManager.createQuery("UPDATE SeatEntityImpl s SET s.isReserved = true WHERE s.idSeat = :idSeat")
                .setParameter("idSeat", idSeat)
                .executeUpdate();

        // Actualizar el asiento del pasajero
        entityManager.createQuery("UPDATE PassengerEntityImpl p SET p.idSeat = :idSeat WHERE p.idPassenger = :idPassenger")
                .setParameter("idSeat", idSeat)
                .setParameter("idPassenger", idPassenger)
                .executeUpdate();

        return findPassengerByIdPassenger(idPassenger);
    }

    @Transactional
    @Override
    public PassengerEntityImpl editPassengerInfo(PassengerEntityImpl passenger) {
        // Actualizar información del pasajero
        entityManager.createQuery(
                        "UPDATE PassengerEntityImpl p SET p.firstName = :firstName, p.lastName = :lastName, " +
                                "p.dateOfBirth = :dateOfBirth, p.documentId = :documentId, p.passportNumber = :passportNumber, " +
                                "p.nationality = :nationality, p.specialRequests = :specialRequests WHERE p.idPassenger = :idPassenger")
                .setParameter("firstName", passenger.getFirstName())
                .setParameter("lastName", passenger.getLastName())
                .setParameter("dateOfBirth", passenger.getDateOfBirth())
                .setParameter("documentId", passenger.getDocumentId())
                .setParameter("passportNumber", passenger.getPassportNumber())
                .setParameter("nationality", passenger.getNationality())
                .setParameter("specialRequests", passenger.getSpecialRequests())
                .setParameter("idPassenger", passenger.getIdPassenger())
                .executeUpdate();

        return findPassengerByIdPassenger(passenger.getIdPassenger());
    }
}

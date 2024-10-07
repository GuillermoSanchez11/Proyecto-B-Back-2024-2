package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Luggage;
import com.codefactory.reserva_b.model.Passenger;
import com.codefactory.reserva_b.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingByUserId(String idBooking) {
        return bookingRepository.findBookingByIdUser(new BigInteger(idBooking));
    }

    @Transactional
    public Booking addBooking(Booking booking) {
        Long bookingId = (Long) entityManager.createNativeQuery("INSERT INTO booking (id_flight, id_user, booking_date, booking_status) " +
                        "VALUES (?, ?, ?, ?) RETURNING id_booking")
                .setParameter(1, booking.getFlight())
                .setParameter(2, booking.getIdUser())
                .setParameter(3, booking.getBookingDate())
                .setParameter(4, booking.getBookingStatus())
                .getSingleResult();
        if (booking.getPassengers() != null) {
            for (Passenger passenger : booking.getPassengers()) {
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
                        .setParameter(1, bookingId)
                        .setParameter(2, passengerId)
                        .executeUpdate();
                entityManager.createNativeQuery("UPDATE seat SET is_reserved = true WHERE id_seat = ?")
                        .setParameter(1, passenger.getIdSeat())
                        .executeUpdate();
                if (passenger.getLuggageIncluded() && passenger.getLuggage() != null) {
                    for (Luggage luggage : passenger.getLuggage()) {
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
            }
        }
        return bookingRepository.findBookingByIdUser(booking.getIdUser());
    }

    @Transactional
    public List<Booking> deleteBooking(String idBooking) {
        List<Long> passengerIds = entityManager.createNativeQuery("SELECT id_passenger FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.valueOf(idBooking))
                .getResultList();

        entityManager.createNativeQuery("DELETE FROM booking_passenger WHERE id_booking = ?")
                .setParameter(1, Long.parseLong(idBooking))
                .executeUpdate();

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

        entityManager.createNativeQuery("DELETE FROM booking WHERE id_booking = ?")
                .setParameter(1, Long.parseLong(idBooking))
                .executeUpdate();

        return bookingRepository.findAll();
    }

    @Transactional
    public Booking addPassenger(Passenger passenger, String idBooking) {
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
            for (Luggage luggage : passenger.getLuggage()) {
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
    public Booking deletePassenger(String idPassenger, String idBooking) {
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
    }

    @Transactional
    public Booking editBookingStatus(String bookingStatus, String idBooking) {
        entityManager.createNativeQuery("UPDATE booking SET booking_status = ? WHERE id_booking = ?")
                .setParameter(1, bookingStatus)
                .setParameter(2, Long.parseLong(idBooking))
                .executeUpdate();
        return bookingRepository.findBookingByIdBooking(new BigInteger(idBooking));
    }
}

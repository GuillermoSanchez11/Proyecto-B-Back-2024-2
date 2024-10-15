package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.*;

import java.time.LocalDateTime;
import java.util.List;

public class BookingResponseDTOImpl implements IBookingResponseDTO {
    private final Long idBooking;
    private final Long idFlight;
    private final FlightResponseDTOImpl flight;
    private final Long idUser;
    private final UsersResponseDTOImpl user;
    private final LocalDateTime bookingDate;
    private final String bookingStatus;
    private final List<PassengerResponseDTOImpl> passengers;
    private final PaymentResponseDTOImpl payment;

    public BookingResponseDTOImpl(Long idBooking, Long idFlight, FlightResponseDTOImpl flight,
                                  Long idUser, UsersResponseDTOImpl user, LocalDateTime bookingDate,
                                  String bookingStatus, List<PassengerResponseDTOImpl> passengers,
                                  PaymentResponseDTOImpl payment) {
        this.idBooking = idBooking;
        this.idFlight = idFlight;
        this.flight = flight;
        this.idUser = idUser;
        this.user = user;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.passengers = passengers;
        this.payment = payment;
    }

    @Override
    public Long getIdBooking() {
        return idBooking;
    }

    @Override
    public Long getIdFlight() {
        return idFlight;
    }

    @Override
    public FlightResponseDTOImpl getFlight() {
        return flight;
    }

    @Override
    public Long getIdUser() {
        return idUser;
    }

    @Override
    public UsersResponseDTOImpl getUser() {
        return user;
    }

    @Override
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    @Override
    public String getBookingStatus() {
        return bookingStatus;
    }

    @Override
    public List<PassengerResponseDTOImpl> getPassengers() {
        return passengers;
    }

    @Override
    public PaymentResponseDTOImpl getPayment() {
        return payment;
    }
}

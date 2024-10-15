package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IBookingRequestDTO;
import com.codefactory.reserva_b.dto.interfaces.IPassengerRequestDTO;

import java.util.List;

public class BookingRequestDTOImpl implements IBookingRequestDTO {
    private final Long idFlight;
    private final Long idUser;
    private final String bookingDate;
    private final String bookingStatus;
    private final List<PassengerRequestDTOImpl> passengers;

    public BookingRequestDTOImpl(Long idFlight, Long idUser, String bookingDate,
                                 String bookingStatus, List<PassengerRequestDTOImpl> passengers) {
        this.idFlight = idFlight;
        this.idUser = idUser;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.passengers = passengers;
    }

    @Override
    public Long getIdFlight() {
        return idFlight;
    }

    @Override
    public Long getIdUser() {
        return idUser;
    }

    @Override
    public String getBookingDate() {
        return bookingDate;
    }

    @Override
    public String getBookingStatus() {
        return bookingStatus;
    }

    @Override
    public List<PassengerRequestDTOImpl> getPassengers() {
        return passengers;
    }
}

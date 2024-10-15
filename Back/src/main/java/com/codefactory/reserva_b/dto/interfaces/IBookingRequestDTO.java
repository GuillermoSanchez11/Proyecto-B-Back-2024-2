package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;

import java.util.List;

public interface IBookingRequestDTO {
    Long getIdFlight();
    Long getIdUser();
    String getBookingDate();
    String getBookingStatus();
    List<PassengerRequestDTOImpl> getPassengers();
}

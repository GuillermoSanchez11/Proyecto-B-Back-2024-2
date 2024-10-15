package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.FlightResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PaymentResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.UsersResponseDTOImpl;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookingResponseDTO {
    Long getIdBooking();
    Long getIdFlight();
    FlightResponseDTOImpl getFlight();
    Long getIdUser();
    UsersResponseDTOImpl getUser();
    LocalDateTime getBookingDate();
    String getBookingStatus();
    List<PassengerResponseDTOImpl> getPassengers();
    PaymentResponseDTOImpl getPayment();
}

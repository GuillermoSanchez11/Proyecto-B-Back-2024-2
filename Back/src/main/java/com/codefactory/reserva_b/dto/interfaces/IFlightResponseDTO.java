package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.CityResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PilotResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PlaneResponseDTOImpl;

import java.time.LocalDateTime;

public interface IFlightResponseDTO {
    Long getIdFlight();
    String getFlightNumber();
    Long getIdPlane();
    PlaneResponseDTOImpl getPlane();
    Long getIdDepartureCity();
    CityResponseDTOImpl getDepartureCity();
    Long getIdArrivalCity();
    CityResponseDTOImpl getArrivalCity();
    LocalDateTime getDepartureTime();
    LocalDateTime getArrivalTime();
    String getStatus();
    String getFlightDuration();
    Float getDistanceKm();
    Integer getSeats();
    Long getIdCaptain();
    PilotResponseDTOImpl getCaptain();
    Long getIdSubCaptain();
    PilotResponseDTOImpl getSubCaptain();
    Float getPriceEconomy();
    Float getPriceBusiness();
    Float getPriceFirstClass();
}

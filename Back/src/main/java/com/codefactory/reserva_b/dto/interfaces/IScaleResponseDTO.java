package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.CityResponseDTOImpl;

public interface IScaleResponseDTO {
    Long getIdScale();
    Long getIdFlight();
    Long getIdCity();
    CityResponseDTOImpl getCity();
    String getArrivalTime();
    String getDepartureTime();
    String getLayoverDuration();
}

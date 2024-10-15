package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IScaleResponseDTO;

public class ScaleResponseDTOImpl implements IScaleResponseDTO {
    private final Long idScale;
    private final Long idFlight;
    private final Long idCity;
    private final CityResponseDTOImpl city;
    private final String arrivalTime;
    private final String departureTime;
    private final String layoverDuration;

    public ScaleResponseDTOImpl(Long idScale, Long idFlight, Long idCity, CityResponseDTOImpl city,
                                String arrivalTime, String departureTime, String layoverDuration) {
        this.idScale = idScale;
        this.idFlight = idFlight;
        this.idCity = idCity;
        this.city = city;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.layoverDuration = layoverDuration;
    }

    @Override
    public Long getIdScale() {
        return idScale;
    }

    @Override
    public Long getIdFlight() {
        return idFlight;
    }

    @Override
    public Long getIdCity() {
        return idCity;
    }

    @Override
    public CityResponseDTOImpl getCity() {
        return city;
    }

    @Override
    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String getLayoverDuration() {
        return layoverDuration;
    }
}

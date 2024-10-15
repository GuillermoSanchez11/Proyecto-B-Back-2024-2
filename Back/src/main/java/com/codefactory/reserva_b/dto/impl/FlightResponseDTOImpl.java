package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IFlightResponseDTO;

import java.time.LocalDateTime;

public class FlightResponseDTOImpl implements IFlightResponseDTO {
    private final Long idFlight;
    private final String flightNumber;
    private final Long idPlane;
    private final PlaneResponseDTOImpl plane;
    private final Long idDepartureCity;
    private final CityResponseDTOImpl departureCity;
    private final Long idArrivalCity;
    private final CityResponseDTOImpl arrivalCity;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final String status;
    private final String flightDuration;
    private final Float distanceKm;
    private final Integer seats;
    private final Long idCaptain;
    private final PilotResponseDTOImpl captain;
    private final Long idSubCaptain;
    private final PilotResponseDTOImpl subCaptain;
    private final Float priceEconomy;
    private final Float priceBusiness;
    private final Float priceFirstClass;

    public FlightResponseDTOImpl(Long idFlight, String flightNumber, Long idPlane, PlaneResponseDTOImpl plane,
                                 Long idDepartureCity, CityResponseDTOImpl departureCity, Long idArrivalCity,
                                 CityResponseDTOImpl arrivalCity, LocalDateTime departureTime, LocalDateTime arrivalTime,
                                 String status, String flightDuration, Float distanceKm, Integer seats,
                                 Long idCaptain, PilotResponseDTOImpl captain, Long idSubCaptain,
                                 PilotResponseDTOImpl subCaptain, Float priceEconomy, Float priceBusiness,
                                 Float priceFirstClass) {
        this.idFlight = idFlight;
        this.flightNumber = flightNumber;
        this.idPlane = idPlane;
        this.plane = plane;
        this.idDepartureCity = idDepartureCity;
        this.departureCity = departureCity;
        this.idArrivalCity = idArrivalCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.flightDuration = flightDuration;
        this.distanceKm = distanceKm;
        this.seats = seats;
        this.idCaptain = idCaptain;
        this.captain = captain;
        this.idSubCaptain = idSubCaptain;
        this.subCaptain = subCaptain;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }

    @Override
    public Long getIdFlight() {
        return idFlight;
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public Long getIdPlane() {
        return idPlane;
    }

    @Override
    public PlaneResponseDTOImpl getPlane() {
        return plane;
    }

    @Override
    public Long getIdDepartureCity() {
        return idDepartureCity;
    }

    @Override
    public CityResponseDTOImpl getDepartureCity() {
        return departureCity;
    }

    @Override
    public Long getIdArrivalCity() {
        return idArrivalCity;
    }

    @Override
    public CityResponseDTOImpl getArrivalCity() {
        return arrivalCity;
    }

    @Override
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getFlightDuration() {
        return flightDuration;
    }

    @Override
    public Float getDistanceKm() {
        return distanceKm;
    }

    @Override
    public Integer getSeats() {
        return seats;
    }

    @Override
    public Long getIdCaptain() {
        return idCaptain;
    }

    @Override
    public PilotResponseDTOImpl getCaptain() {
        return captain;
    }

    @Override
    public Long getIdSubCaptain() {
        return idSubCaptain;
    }

    @Override
    public PilotResponseDTOImpl getSubCaptain() {
        return subCaptain;
    }

    @Override
    public Float getPriceEconomy() {
        return priceEconomy;
    }

    @Override
    public Float getPriceBusiness() {
        return priceBusiness;
    }

    @Override
    public Float getPriceFirstClass() {
        return priceFirstClass;
    }
}

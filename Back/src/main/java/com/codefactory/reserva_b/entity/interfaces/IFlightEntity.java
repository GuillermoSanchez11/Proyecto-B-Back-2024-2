package com.codefactory.reserva_b.entity.interfaces;

import com.codefactory.reserva_b.entity.impl.CityEntityImpl;
import com.codefactory.reserva_b.entity.impl.PilotEntityImpl;
import com.codefactory.reserva_b.entity.impl.PlaneEntityImpl;
import com.codefactory.reserva_b.entity.impl.ScaleEntityImpl;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface IFlightEntity {
    // Getters
    BigInteger getIdFlight();
    Long getFlightNumber();
    BigInteger getIdPlane();
    PlaneEntityImpl getPlane();
    BigInteger getIdDepartureCity();
    CityEntityImpl getDepartureCity();
    BigInteger getIdArrivalCity();
    CityEntityImpl getArrivalCity();
    LocalDateTime getDepartureTime();
    LocalDateTime getArrivalTime();
    String getStatus();
    String getFlightDuration();
    Double getDistanceKm();
    Integer getSeats();
    BigInteger getIdCaptain();
    PilotEntityImpl getCaptain();
    BigInteger getIdSubCaptain();
    PilotEntityImpl getSubCaptain();
    Double getPriceEconomy();
    Double getPriceBusiness();
    Double getPriceFirstClass();
    List<ScaleEntityImpl> getScales();

    // Setters
    void setIdFlight(BigInteger idFlight);
    void setFlightNumber(Long flightNumber);
    void setIdPlane(BigInteger idPlane);
    void setPlane(PlaneEntityImpl plane);
    void setIdDepartureCity(BigInteger idDepartureCity);
    void setDepartureCity(CityEntityImpl departureCity);
    void setIdArrivalCity(BigInteger idArrivalCity);
    void setArrivalCity(CityEntityImpl arrivalCity);
    void setDepartureTime(LocalDateTime departureTime);
    void setArrivalTime(LocalDateTime arrivalTime);
    void setStatus(String status);
    void setFlightDuration(String flightDuration);
    void setDistanceKm(Double distanceKm);
    void setSeats(Integer seats);
    void setIdCaptain(BigInteger idCaptain);
    void setCaptain(PilotEntityImpl captain);
    void setIdSubCaptain(BigInteger idSubCaptain);
    void setSubCaptain(PilotEntityImpl subCaptain);
    void setPriceEconomy(Double priceEconomy);
    void setPriceBusiness(Double priceBusiness);
    void setPriceFirstClass(Double priceFirstClass);
    void setScales(List<ScaleEntityImpl> scales);
}

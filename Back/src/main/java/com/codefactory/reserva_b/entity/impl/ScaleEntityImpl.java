package com.codefactory.reserva_b.entity.impl;

import com.codefactory.reserva_b.entity.interfaces.IEntity;
import com.codefactory.reserva_b.entity.interfaces.IScaleEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "scale")
public class ScaleEntityImpl implements IScaleEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scale")
    private BigInteger idScale;

    @Column(name = "id_flight", nullable = false)
    private BigInteger idFlight;  // Relación con PassengerEntityImpl

    @Column(name = "id_city", nullable = false)
    private BigInteger idCity;

    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false, insertable=false, updatable=false)
    private CityEntityImpl city;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "layover_duration", nullable = false)
    private LocalTime layoverDuration;

    // Constructor
    public ScaleEntityImpl(BigInteger idFlight, BigInteger idCity, LocalDateTime arrivalTime, LocalDateTime departureTime, LocalTime layoverDuration) {
        this.idFlight = idFlight;
        this.idCity = idCity;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.layoverDuration = layoverDuration;
    }

    public ScaleEntityImpl() {
    }

    public BigInteger getIdScale() {
        return idScale;
    }

    public void setIdScale(BigInteger idScale) {
        this.idScale = idScale;
    }

    public BigInteger getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(BigInteger idFlight) {
        this.idFlight = idFlight;
    }

    public CityEntityImpl getCity() {
        return city;
    }

    public void setCity(CityEntityImpl city) {
        this.city = city;
    }

    public BigInteger getIdCity() {
        return idCity;
    }

    public void setIdCity(BigInteger idCity) {
        this.idCity = idCity;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getLayoverDuration() {
        return layoverDuration;
    }

    public void setLayoverDuration(LocalTime layoverDuration) {
        this.layoverDuration = layoverDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScaleEntityImpl that = (ScaleEntityImpl) o;
        return Objects.equals(idScale, that.idScale);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idScale);
    }

    @Override
    public String toString() {
        return "ScaleEntityImpl{" +
                "idScale=" + idScale +
                ", idFlight=" + idFlight +
                ", idCity=" + idCity +
                ", city=" + city +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", layoverDuration=" + layoverDuration +
                '}';
    }
}

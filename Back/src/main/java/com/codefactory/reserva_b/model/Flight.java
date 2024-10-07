package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private BigInteger idFlight;

    @Column(name = "flight_number", nullable = false)
    private Long flightNumber;

    @Column(name = "id_plane", nullable = false)
    private BigInteger idPlane;

    @Column(name = "id_departure_city", nullable = false)
    private BigInteger idDepartureCity;

    @Column(name = "id_arrival_city", nullable = false)
    private BigInteger idArrivalCity;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "flight_duration", nullable = false)
    private String flightDuration; // Puede ser un String, o usar Duration si se requiere

    @Column(name = "distance_km", nullable = false)
    private Double distanceKm;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Column(name = "id_captain", nullable = false)
    private BigInteger idCaptain;

    @Column(name = "id_subcaptain", nullable = false)
    private BigInteger idSubCaptain;

    @Column(name = "price_economy", nullable = false)
    private Double priceEconomy;

    @Column(name = "price_business", nullable = false)
    private Double priceBusiness;

    @Column(name = "price_first_class", nullable = false)
    private Double priceFirstClass;

    // Constructor
    public Flight(BigInteger idFlight, Long flightNumber, BigInteger idPlane, BigInteger idDepartureCity,
                  BigInteger idArrivalCity, LocalDateTime departureTime, LocalDateTime arrivalTime,
                  String status, String flightDuration, Double distanceKm,
                  Integer seats, BigInteger idCaptain, BigInteger idSubCaptain,
                  Double priceEconomy, Double priceBusiness, Double priceFirstClass) {
        this.idFlight = idFlight;
        this.flightNumber = flightNumber;
        this.idPlane = idPlane;
        this.idDepartureCity = idDepartureCity;
        this.idArrivalCity = idArrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.flightDuration = flightDuration; // Ajusta según el tipo que decidas usar
        this.distanceKm = distanceKm;
        this.seats = seats;
        this.idCaptain = idCaptain;
        this.idSubCaptain = idSubCaptain;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }

    public Flight() {

    }

    // Getters y Setters

    public BigInteger getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(BigInteger idFlight) {
        this.idFlight = idFlight;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public BigInteger getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(BigInteger idPlane) {
        this.idPlane = idPlane;
    }

    public BigInteger getIdDepartureCity() {
        return idDepartureCity;
    }

    public void setIdDepartureCity(BigInteger idDepartureCity) {
        this.idDepartureCity = idDepartureCity;
    }

    public BigInteger getIdArrivalCity() {
        return idArrivalCity;
    }

    public void setIdArrivalCity(BigInteger idArrivalCity) {
        this.idArrivalCity = idArrivalCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public BigInteger getIdCaptain() {
        return idCaptain;
    }

    public void setIdCaptain(BigInteger idCaptain) {
        this.idCaptain = idCaptain;
    }

    public BigInteger getIdSubCaptain() {
        return idSubCaptain;
    }

    public void setIdSubCaptain(BigInteger idSubCaptain) {
        this.idSubCaptain = idSubCaptain;
    }

    public Double getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(Double priceEconomy) {
        this.priceEconomy = priceEconomy;
    }

    public Double getPriceBusiness() {
        return priceBusiness;
    }

    public void setPriceBusiness(Double priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    public Double getPriceFirstClass() {
        return priceFirstClass;
    }

    public void setPriceFirstClass(Double priceFirstClass) {
        this.priceFirstClass = priceFirstClass;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(idFlight, flight.idFlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", flightNumber=" + flightNumber +
                ", idPlane=" + idPlane +
                ", idDepartureCity=" + idDepartureCity +
                ", idArrivalCity=" + idArrivalCity +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", status='" + status + '\'' +
                ", flightDuration='" + flightDuration + '\'' +
                ", distanceKm=" + distanceKm +
                ", seats=" + seats +
                ", idCaptain=" + idCaptain +
                ", idSubCaptain=" + idSubCaptain +
                ", priceEconomy=" + priceEconomy +
                ", priceBusiness=" + priceBusiness +
                ", priceFirstClass=" + priceFirstClass +
                '}';
    }
}
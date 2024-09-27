package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Long idFlight;

    @ManyToOne
    @JoinColumn(name = "id_plane", nullable = false)
    private Plane plane;  // Relación con Plane

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "aeroline", nullable = false)
    private String aeroline;

    @Column(name = "captain", nullable = false)
    private String captain;

    @Column(name = "sub_captain", nullable = false)
    private String subCaptain;

    // Constructor por defecto
    public Flight() {
    }

    // Constructor con todos los campos
    public Flight(Long idFlight, Plane plane, String origin, String destination, LocalDate departureDate, LocalDate arrivalDate, String status, String aeroline, String captain, String subCaptain) {
        this.idFlight = idFlight;
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.status = status;
        this.aeroline = aeroline;
        this.captain = captain;
        this.subCaptain = subCaptain;
    }

    // Getters y Setters
    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAeroline() {
        return aeroline;
    }

    public void setAeroline(String aeroline) {
        this.aeroline = aeroline;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getSubCaptain() {
        return subCaptain;
    }

    public void setSubCaptain(String subCaptain) {
        this.subCaptain = subCaptain;
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
                ", Plane=" + plane +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", status='" + status + '\'' +
                ", aeroline='" + aeroline + '\'' +
                ", captain='" + captain + '\'' +
                ", subCaptain='" + subCaptain + '\'' +
                '}';
    }
}
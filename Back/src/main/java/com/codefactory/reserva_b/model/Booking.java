package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking", nullable = false)
    private BigInteger idBooking;

    @Column(name = "id_flight", nullable = false)
    private BigInteger flight;  // Relación con Passenger

    @Column(name = "id_user", nullable = false)
    private BigInteger idUser;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, insertable=false, updatable=false)
    private Users user;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "booking_passenger", joinColumns = @JoinColumn(name = "id_booking"), inverseJoinColumns = @JoinColumn(name = "id_passenger"))
    private List<Passenger> passengers;

    // Constructor por defecto
    public Booking() {
    }

    // Constructor con todos los campos
    public Booking(BigInteger idBooking, BigInteger flight, BigInteger idUser, LocalDateTime bookingDate,
                   String bookingStatus) {
        this.idBooking = idBooking;
        this.flight = flight;
        this.idUser = idUser;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }
    // Getters y Setters


    public BigInteger getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(BigInteger idBooking) {
        this.idBooking = idBooking;
    }

    public BigInteger getFlight() {
        return flight;
    }

    public void setFlight(BigInteger flight) {
        this.flight = flight;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(idBooking, booking.idBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", flight=" + flight +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +

                '}';
    }
}

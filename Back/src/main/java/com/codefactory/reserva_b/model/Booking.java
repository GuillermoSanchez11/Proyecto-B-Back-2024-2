package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Long idBooking;

    @Column(name = "id_flight", nullable = false)
    private Long flight;  // Relación con Passenger

    @Column(name = "id_user", nullable = false) // Corregido "id_uservarchar" a "id_user"
    private Long idUser;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;


    // Constructor por defecto
    public Booking() {
    }

    // Constructor con todos los campos
    public Booking(Long idBooking, Long flight, Long idUser, LocalDateTime bookingDate,
                   String bookingStatus) {
        this.idBooking = idBooking;
        this.flight = flight;
        this.idUser = idUser;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;

    }

    // Getters y Setters


    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Long getFlight() {
        return flight;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
                ", idUser=" + idUser +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +

                '}';
    }
}

package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "seat")
public class Seat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    private Long idSeat;

    @Column(name = "id_flight", nullable = false)
    private Long flight;  // Relación con Flight

    @Column(name = "seat_type", nullable = false)
    private String seatType;

    @Column(name = "is_avaliable", nullable = false)
    private boolean isAvailable;

    @Column(name = "price", nullable = false)
    private double price;

    // Constructor por defecto
    public Seat() {
    }

    // Constructor con todos los campos
    public Seat(Long idSeat, Long flight, String seatType, boolean isAvailable, double price) {
        this.idSeat = idSeat;
        this.flight = flight;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    // Getters y Setters
    public Long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Long idSeat) {
        this.idSeat = idSeat;
    }

    public Long getFlight() {
        return flight;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat seat)) return false;
        return Objects.equals(idSeat, seat.idSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeat);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "idSeat=" + idSeat +
                ", Flight=" + flight +
                ", seatType='" + seatType + '\'' +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}

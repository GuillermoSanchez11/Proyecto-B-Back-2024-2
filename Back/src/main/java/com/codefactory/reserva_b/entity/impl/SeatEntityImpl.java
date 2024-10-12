package com.codefactory.reserva_b.entity.impl;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import com.codefactory.reserva_b.entity.interfaces.ISeatEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "seat")
public class SeatEntityImpl implements ISeatEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    private BigInteger idSeat;

    @Column(name = "id_flight", nullable = false)
    private BigInteger idFlight;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "seat_class", nullable = false)
    private String seatClass;

    // Constructor
    public SeatEntityImpl(BigInteger idFlight, String seatNumber, Boolean isReserved, Double price, String seatClass) {
        this.idFlight = idFlight;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
        this.price = price;
        this.seatClass = seatClass;
    }

    public SeatEntityImpl() {
    }

    public BigInteger getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(BigInteger idSeat) {
        this.idSeat = idSeat;
    }

    public BigInteger getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(BigInteger idFlight) {
        this.idFlight = idFlight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntityImpl that = (SeatEntityImpl) o;
        return Objects.equals(idSeat, that.idSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSeat);
    }

    @Override
    public String toString() {
        return "SeatEntityImpl{" +
                "idSeat=" + idSeat +
                ", idFlight=" + idFlight +
                ", seatNumber='" + seatNumber + '\'' +
                ", isReserved=" + isReserved +
                ", price=" + price +
                ", seatClass='" + seatClass + '\'' +
                '}';
    }
}

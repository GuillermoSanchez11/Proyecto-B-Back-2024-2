package com.codefactory.reserva_b.entity.impl;
import com.codefactory.reserva_b.entity.interfaces.IBookingEntity;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class BookingEntityImpl implements IBookingEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking", nullable = false)
    private BigInteger idBooking;

    @Column(name = "id_flight", nullable = false)
    private BigInteger idFlight;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false, insertable=false, updatable=false)
    private FlightEntityImpl flight;

    @Column(name = "id_user", nullable = false)
    private BigInteger idUser;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, insertable=false, updatable=false)
    private UsersEntityImpl user;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "booking_passenger", joinColumns = @JoinColumn(name = "id_booking"), inverseJoinColumns = @JoinColumn(name = "id_passenger"))
    private List<PassengerEntityImpl> passengers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_booking")
    private PaymentEntityImpl payment;

    // Constructor por defecto
    public BookingEntityImpl() {
    }

    // Constructor con todos los campos
    public BookingEntityImpl(BigInteger idFlight, BigInteger idUser, LocalDateTime bookingDate, String bookingStatus) {
        this.idFlight = idFlight;
        this.idUser = idUser;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    public BigInteger getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(BigInteger idFlight) {
        this.idFlight = idFlight;
    }

    public BigInteger getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(BigInteger idBooking) {
        this.idBooking = idBooking;
    }

    public FlightEntityImpl getFlight() {
        return flight;
    }

    public void setFlight(FlightEntityImpl flight) {
        this.flight = flight;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public UsersEntityImpl getUser() {
        return user;
    }

    public void setUser(UsersEntityImpl user) {
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

    public List<PassengerEntityImpl> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerEntityImpl> passengers) {
        this.passengers = passengers;
    }

    public PaymentEntityImpl getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntityImpl payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntityImpl that = (BookingEntityImpl) o;
        return Objects.equals(idBooking, that.idBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idBooking);
    }

    @Override
    public String toString() {
        return "BookingEntityImpl{" +
                "idBooking=" + idBooking +
                ", idFlight=" + idFlight +
                ", flight=" + flight +
                ", idUser=" + idUser +
                ", user=" + user +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", passengers=" + passengers +
                ", payment=" + payment +
                '}';
    }
}

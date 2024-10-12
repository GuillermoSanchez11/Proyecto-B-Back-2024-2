package com.codefactory.reserva_b.entity.interfaces;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.entity.impl.PaymentEntityImpl;
import com.codefactory.reserva_b.entity.impl.UsersEntityImpl;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface IBookingEntity {
    // Getters
    BigInteger getIdFlight();
    BigInteger getIdBooking();
    FlightEntityImpl getFlight();
    BigInteger getIdUser();
    UsersEntityImpl getUser();
    LocalDateTime getBookingDate();
    String getBookingStatus();
    List<PassengerEntityImpl> getPassengers();
    PaymentEntityImpl getPayment();

    // Setters
    void setIdFlight(BigInteger idFlight);
    void setIdBooking(BigInteger idBooking);
    void setFlight(FlightEntityImpl flight);
    void setIdUser(BigInteger idUser);
    void setUser(UsersEntityImpl user);
    void setBookingDate(LocalDateTime bookingDate);
    void setBookingStatus(String bookingStatus);
    void setPassengers(List<PassengerEntityImpl> passengers);
    void setPayment(PaymentEntityImpl payment);
}

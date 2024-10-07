package com.codefactory.reserva_b.repository;
import com.codefactory.reserva_b.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BookingRepository extends JpaRepository<Booking, BigInteger> {
    Booking findBookingByIdUser(BigInteger idUser);
    Booking findBookingByIdBooking(BigInteger bookingId);
}

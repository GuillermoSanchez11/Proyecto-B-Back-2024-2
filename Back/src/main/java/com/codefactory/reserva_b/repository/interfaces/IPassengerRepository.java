package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IPassengerRepository extends JpaRepository<PassengerEntityImpl, BigInteger> {
    PassengerEntityImpl findPassengerByIdPassenger(BigInteger id);
    BookingEntityImpl createPassenger(PassengerEntityImpl passenger, String idBooking);
    BookingEntityImpl deletePassenger(String idPassenger, String idBooking);

}

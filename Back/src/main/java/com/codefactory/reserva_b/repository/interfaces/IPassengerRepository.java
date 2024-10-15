package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface IPassengerRepository {
    PassengerEntityImpl findPassengerByIdPassenger(BigInteger idPassenger);
    List<PassengerEntityImpl> findPassengersByIdBooking(BigInteger idBooking);
    PassengerEntityImpl createPassenger(PassengerRequestDTOImpl passenger, BigInteger idBooking);
    BookingEntityImpl deletePassenger(BigInteger idPassenger, BigInteger idBooking);
    PassengerEntityImpl editPassengerSeat(BigInteger idPassenger, BigInteger idSeat);
    PassengerEntityImpl editPassengerInfo(BigInteger idPassenger, PassengerRequestDTOImpl passenger);
}

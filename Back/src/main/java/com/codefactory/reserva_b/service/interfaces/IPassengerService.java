package com.codefactory.reserva_b.service.interfaces;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;

import java.util.List;

public interface IPassengerService {
    PassengerEntityImpl findPassengerByIdPassenger(String id);
    List<PassengerEntityImpl> findPassengersByIdBooking(String idBooking);
    PassengerEntityImpl addPassenger(PassengerEntityImpl passenger, String idBooking);
    BookingEntityImpl deletePassenger(String idPassenger, String idBooking);
    PassengerEntityImpl editPassengerSeat(String idPassenger, String idSeat);
    PassengerEntityImpl editPassengerInfo(PassengerEntityImpl passenger);
}

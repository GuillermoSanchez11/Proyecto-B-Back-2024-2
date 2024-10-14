package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IPassengerRepository;
import com.codefactory.reserva_b.service.interfaces.IPassengerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements IPassengerService {
    @Autowired
    private IPassengerRepository passengerRepository;

    @Override
    public PassengerEntityImpl findPassengerByIdPassenger(String idPassenger) {
        return passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
    }

    @Override
        public List<PassengerEntityImpl> findPassengersByIdBooking(String idBooking) {
        return passengerRepository.findPassengersByIdBooking(new BigInteger(idBooking));
    }

    @Override
    public PassengerEntityImpl addPassenger(PassengerEntityImpl passenger, String idBooking) {
        return passengerRepository.createPassenger(passenger, new BigInteger(idBooking));
    }

    @Override
    public BookingEntityImpl deletePassenger(String idPassenger, String idBooking) {
        return passengerRepository.deletePassenger(new BigInteger(idPassenger), new BigInteger(idBooking));
    }

    @Override
    public PassengerEntityImpl editPassengerSeat(String idPassenger, String idSeat) {
        return passengerRepository.editPassengerSeat(new BigInteger(idPassenger), new BigInteger(idSeat));
    }

    @Override
    public PassengerEntityImpl editPassengerInfo(PassengerEntityImpl passenger) {
        return passengerRepository.editPassengerInfo(passenger);
    }
}

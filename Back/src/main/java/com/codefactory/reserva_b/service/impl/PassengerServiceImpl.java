package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IPassengerRepository;
import com.codefactory.reserva_b.service.interfaces.IPassengerService;
import com.codefactory.reserva_b.util.interfaces.IBookingMapper;
import com.codefactory.reserva_b.util.interfaces.IPassengerMapper;
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
    @Autowired
    private IPassengerMapper passengerMapper;
    @Autowired
    private IBookingMapper bookingMapper;

    @Override
    public PassengerResponseDTOImpl findPassengerByIdPassenger(String idPassenger) {
        PassengerEntityImpl passenger = passengerRepository.findPassengerByIdPassenger(new BigInteger(idPassenger));
        return passengerMapper.mapPassengerEntityToPassengerResponseDTO(passenger);
    }

    @Override
        public List<PassengerResponseDTOImpl> findPassengersByIdBooking(String idBooking) {
        List<PassengerEntityImpl> passengers = passengerRepository.findPassengersByIdBooking(new BigInteger(idBooking));
        return passengerMapper.mapPassengerEntitiesToPassengerResponseDTOs(passengers);
    }

    @Override
    public PassengerResponseDTOImpl addPassenger(PassengerRequestDTOImpl passenger, String idBooking) {
        PassengerEntityImpl newPassenger = passengerRepository.createPassenger(passenger, new BigInteger(idBooking));
        return passengerMapper.mapPassengerEntityToPassengerResponseDTO(newPassenger);
    }

    @Override
    public BookingResponseDTOImpl deletePassenger(String idPassenger, String idBooking) {
        BookingEntityImpl booking = passengerRepository.deletePassenger(new BigInteger(idPassenger), new BigInteger(idBooking));
        return bookingMapper.mapBookingEntityToBookingResponseDTO(booking);
    }

    @Override
    public PassengerResponseDTOImpl editPassengerSeat(String idPassenger, String idSeat) {
        PassengerEntityImpl passenger = passengerRepository.editPassengerSeat(new BigInteger(idPassenger), new BigInteger(idSeat));
        return passengerMapper.mapPassengerEntityToPassengerResponseDTO(passenger);
    }

    @Override
    public PassengerResponseDTOImpl editPassengerInfo(String idPassenger, PassengerRequestDTOImpl passenger) {
        PassengerEntityImpl editPassenger = passengerRepository.editPassengerInfo(new BigInteger(idPassenger), passenger);
        return passengerMapper.mapPassengerEntityToPassengerResponseDTO(editPassenger);
    }
}

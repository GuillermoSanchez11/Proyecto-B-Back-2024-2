package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Flight;
import com.codefactory.reserva_b.repository.BookingRepository;
import com.codefactory.reserva_b.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }
}

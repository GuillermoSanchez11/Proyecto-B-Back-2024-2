package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl {
    @Autowired
    private IFlightRepository flightRepository;

    public List<FlightEntityImpl> getFlights() {
        return flightRepository.findAll();
    }
}

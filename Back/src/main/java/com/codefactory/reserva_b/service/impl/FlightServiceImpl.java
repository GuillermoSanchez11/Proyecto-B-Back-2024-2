package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IFlightRepository;
import com.codefactory.reserva_b.service.interfaces.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public List<FlightEntityImpl> findAllFlights() {
        return flightRepository.findAllFlights();
    }
}

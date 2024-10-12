package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @QueryMapping()
    public List<FlightEntityImpl> allFlights() {
        return flightService.getFlights();
    }
}

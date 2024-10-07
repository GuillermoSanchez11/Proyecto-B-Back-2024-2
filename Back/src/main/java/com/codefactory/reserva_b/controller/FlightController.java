package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.model.Flight;
import com.codefactory.reserva_b.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @QueryMapping()
    public List<Flight> allFlights() {
        return flightService.getFlights();
    }
}

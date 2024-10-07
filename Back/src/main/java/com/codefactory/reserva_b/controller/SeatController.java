package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.model.Seat;
import com.codefactory.reserva_b.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @QueryMapping()
    public List<Seat> getAvailableSeats(@Argument String idFlight) {
        return seatService.getAvailableSeats(idFlight);
    }
}

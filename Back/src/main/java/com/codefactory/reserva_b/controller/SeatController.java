package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.dto.impl.SeatResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.service.impl.SeatServiceImpl;
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
    private SeatServiceImpl seatService;

    @QueryMapping()
    public List<SeatResponseDTOImpl> findAllAvailableSeats(@Argument String idFlight) {
        return seatService.findAllAvailableSeats(idFlight);
    }
}

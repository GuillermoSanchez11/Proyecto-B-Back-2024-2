package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.model.Luggage;
import com.codefactory.reserva_b.model.Passenger;
import com.codefactory.reserva_b.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @QueryMapping()
    public Passenger getPassengerById(@Argument String idPassenger) {
        return passengerService.getPassengerById(idPassenger);
    }

    @QueryMapping()
    public List<Passenger> getPassengersByBookingId(@Argument String idBooking) {
        return passengerService.getPassengersByBookingId(idBooking);
    }

    @MutationMapping()
    public Passenger editPassengerSeat(@Argument String idPassenger, @Argument String newIdSeat) {
        return passengerService.editPassengerSeat(idPassenger, newIdSeat);
    }

    @MutationMapping()
    public Passenger editPassengerInfo(@Argument Passenger passenger) {
        return passengerService.editPassengerInfo(passenger);
    }

    @MutationMapping()
    public Passenger editPassengerLuggage(@Argument String idLuggage, @Argument Luggage luggage) {
        return passengerService.editPassengerLuggage(idLuggage, luggage);
    }

    @MutationMapping()
    public Passenger addLuggage(@Argument String idPassenger, @Argument Luggage luggage) {
        return passengerService.addLuggage(idPassenger, luggage);
    }

    @MutationMapping()
    public Passenger deleteLuggage(@Argument String idPassenger, @Argument String idLuggage) {
        return passengerService.deleteLuggage(idPassenger, idLuggage);
    }
}

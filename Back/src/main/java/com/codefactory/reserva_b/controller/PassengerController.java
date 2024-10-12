package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.service.impl.PassengerServiceImpl;
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
    private PassengerServiceImpl passengerService;

    @QueryMapping()
    public PassengerEntityImpl getPassengerById(@Argument String idPassenger) {
        return passengerService.getPassengerById(idPassenger);
    }

    @QueryMapping()
    public List<PassengerEntityImpl> getPassengersByBookingId(@Argument String idBooking) {
        return passengerService.getPassengersByBookingId(idBooking);
    }

    @MutationMapping()
    public PassengerEntityImpl editPassengerSeat(@Argument String idPassenger, @Argument String newIdSeat) {
        return passengerService.editPassengerSeat(idPassenger, newIdSeat);
    }

    @MutationMapping()
    public PassengerEntityImpl editPassengerInfo(@Argument PassengerEntityImpl passenger) {
        return passengerService.editPassengerInfo(passenger);
    }

    @MutationMapping()
    public PassengerEntityImpl editPassengerLuggage(@Argument String idLuggage, @Argument LuggageEntityImpl luggage) {
        return passengerService.editPassengerLuggage(idLuggage, luggage);
    }

    @MutationMapping()
    public PassengerEntityImpl addLuggage(@Argument String idPassenger, @Argument LuggageEntityImpl luggage) {
        return passengerService.addLuggage(idPassenger, luggage);
    }

    @MutationMapping()
    public PassengerEntityImpl deleteLuggage(@Argument String idPassenger, @Argument String idLuggage) {
        return passengerService.deleteLuggage(idPassenger, idLuggage);
    }
}

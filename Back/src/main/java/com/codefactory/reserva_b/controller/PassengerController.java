package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.service.impl.BookingServiceImpl;
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
    public PassengerEntityImpl findPassengerByIdPassenger(@Argument String idPassenger) {
        return passengerService.findPassengerByIdPassenger(idPassenger);
    }

    @QueryMapping()
    public List<PassengerEntityImpl> findPassengersByIdBooking(@Argument String idBooking) {
        return passengerService.findPassengersByIdBooking(idBooking);
    }

    @MutationMapping()
    public PassengerEntityImpl addPassenger(@Argument PassengerEntityImpl passenger, @Argument String idBooking) {
        return passengerService.addPassenger(passenger, idBooking);
    }

    @MutationMapping()
    public BookingEntityImpl deletePassenger(@Argument String idPassenger, @Argument String idBooking) {
        return passengerService.deletePassenger(idPassenger, idBooking);
    }

    @MutationMapping()
    public PassengerEntityImpl editPassengerSeat(@Argument String idPassenger, @Argument String idSeat, @Argument String idBooking) {
        return passengerService.editPassengerSeat(idPassenger, idSeat, idBooking);
    }

    @MutationMapping()
    public PassengerEntityImpl editPassengerInfo(@Argument PassengerEntityImpl passenger) {
        return passengerService.editPassengerInfo(passenger);
    }
}

package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
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
    public PassengerResponseDTOImpl findPassengerByIdPassenger(@Argument String idPassenger) {
        return passengerService.findPassengerByIdPassenger(idPassenger);
    }

    @QueryMapping()
    public List<PassengerResponseDTOImpl> findPassengersByIdBooking(@Argument String idBooking) {
        return passengerService.findPassengersByIdBooking(idBooking);
    }

    @MutationMapping()
    public PassengerResponseDTOImpl addPassenger(@Argument PassengerRequestDTOImpl passenger, @Argument String idBooking) {
        return passengerService.addPassenger(passenger, idBooking);
    }

    @MutationMapping()
    public BookingResponseDTOImpl deletePassenger(@Argument String idPassenger, @Argument String idBooking) {
        return passengerService.deletePassenger(idPassenger, idBooking);
    }

    @MutationMapping()
    public PassengerResponseDTOImpl editPassengerSeat(@Argument String idPassenger, @Argument String idSeat) {
        return passengerService.editPassengerSeat(idPassenger, idSeat);
    }

    @MutationMapping()
    public PassengerResponseDTOImpl editPassengerInfo(@Argument String idPassenger, @Argument PassengerRequestDTOImpl passenger) {
        return passengerService.editPassengerInfo(idPassenger, passenger);
    }
}

package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Passenger;
import com.codefactory.reserva_b.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @QueryMapping()
    public List<Booking> allBookings() {
        return bookingService.getBookings();
    }
    @QueryMapping()
    public Booking bookingByUserId(@Argument String idUser) {
        return bookingService.getBookingByUserId(idUser);
    }
    @MutationMapping()
    public Booking addBooking(@Argument Booking booking) {
        return bookingService.addBooking(booking);
    }
    @MutationMapping()
    public List<Booking> deleteBooking(@Argument String idBooking) {
        return bookingService.deleteBooking(idBooking);
    }
    @MutationMapping()
    public Booking addPassenger(@Argument Passenger passenger, @Argument String idBooking) {
        return bookingService.addPassenger(passenger, idBooking);
    }
    @MutationMapping()
    public Booking deletePassenger(@Argument String idPassenger, @Argument String idBooking) {
        return bookingService.deletePassenger(idPassenger, idBooking);
    }
    @MutationMapping()
    public Booking editBookingStatus(@Argument String bookingStatus, @Argument String idBooking) {
        return bookingService.editBookingStatus(bookingStatus, idBooking);
    }
}

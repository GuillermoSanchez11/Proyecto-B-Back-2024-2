package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Plane;
import com.codefactory.reserva_b.service.BookingService;
import com.codefactory.reserva_b.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private PlaneService planeService;

    @QueryMapping()
    public List<Booking> allBookings() {
        return bookingService.getBookings();
    }
    @QueryMapping()
    public List<Plane> allPlanes() {
        return planeService.getPlanes();
    }
    @QueryMapping()
    public Booking bookingById(@Argument String idBooking) {
        return bookingService.getBookingById(idBooking);
    }
}

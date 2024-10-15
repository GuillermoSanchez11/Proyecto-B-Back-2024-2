package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.dto.impl.BookingRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.service.impl.BookingServiceImpl;
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
    private BookingServiceImpl bookingService;

    @QueryMapping()
    public List<BookingResponseDTOImpl> findAllBookings() {
        return bookingService.findAllBookings();
    }
    @QueryMapping()
    public List<BookingResponseDTOImpl> findBookingsByIdUser(@Argument String idUser) {
        return bookingService.findBookingsByIdUser(idUser);
    }
    @QueryMapping()
    public BookingResponseDTOImpl findBookingsByIdBooking(@Argument String idBooking) {
        return bookingService.findBookingByIdBooking(idBooking);
    }
    @MutationMapping()
    public BookingResponseDTOImpl addBooking(@Argument BookingRequestDTOImpl booking) {
        return bookingService.addBooking(booking);
    }
    @MutationMapping()
    public List<BookingResponseDTOImpl> deleteBooking(@Argument String idBooking) {
        return bookingService.deleteBooking(idBooking);
    }
    @MutationMapping()
    public BookingResponseDTOImpl editBookingStatus(@Argument String bookingStatus, @Argument String idBooking) {
        return bookingService.editBookingStatus(bookingStatus, idBooking);
    }
}

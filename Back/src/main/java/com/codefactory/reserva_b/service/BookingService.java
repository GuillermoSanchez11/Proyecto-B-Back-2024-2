package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }
    public Booking getBookingById(String idBooking) {
        return bookingRepository.findBookingByIdBooking(Long.parseLong(idBooking));
    }
}

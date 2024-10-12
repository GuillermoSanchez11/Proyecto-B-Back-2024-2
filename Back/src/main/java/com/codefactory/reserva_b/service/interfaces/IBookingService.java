package com.codefactory.reserva_b.service.interfaces;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;

import java.util.List;

public interface IBookingService {
    List<BookingEntityImpl> findAllBookings();
    List<BookingEntityImpl> findBookingsByIdUser(String idUser);
    BookingEntityImpl findBookingByIdBooking(String idBooking);
    BookingEntityImpl addBooking(BookingEntityImpl booking);
    List<BookingEntityImpl> deleteBooking(String idBooking);
    BookingEntityImpl editBookingStatus(String bookingStatus, String idBooking);
}

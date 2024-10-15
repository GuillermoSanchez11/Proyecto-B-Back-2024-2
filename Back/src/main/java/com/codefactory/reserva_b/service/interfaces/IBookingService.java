package com.codefactory.reserva_b.service.interfaces;


import com.codefactory.reserva_b.dto.impl.BookingRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;

import java.util.List;

public interface IBookingService {
    List<BookingResponseDTOImpl> findAllBookings();
    List<BookingResponseDTOImpl> findBookingsByIdUser(String idUser);
    BookingResponseDTOImpl findBookingByIdBooking(String idBooking);
    BookingResponseDTOImpl addBooking(BookingRequestDTOImpl booking);
    List<BookingResponseDTOImpl> deleteBooking(String idBooking);
    BookingResponseDTOImpl editBookingStatus(String bookingStatus, String idBooking);
}

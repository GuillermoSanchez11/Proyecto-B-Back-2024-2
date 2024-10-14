package com.codefactory.reserva_b.repository.interfaces;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface IBookingRepository {
    List<BookingEntityImpl> findAllBookings();
    List<BookingEntityImpl> findBookingsByIdUser(BigInteger idUser);
    BookingEntityImpl findBookingByIdBooking(BigInteger idBooking);
    BookingEntityImpl createBooking(BookingEntityImpl booking);
    List<BookingEntityImpl> deleteBooking(BigInteger idBooking);
    BookingEntityImpl editBookingStatus(String bookingStatus, BigInteger idBooking);
}

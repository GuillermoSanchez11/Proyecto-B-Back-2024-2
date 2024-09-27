package com.codefactory.reserva_b.repository;
import com.codefactory.reserva_b.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findBookingByIdBooking(Long idBooking);
}

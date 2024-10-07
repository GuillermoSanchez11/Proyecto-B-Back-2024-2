package com.codefactory.reserva_b.repository;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface SeatRepository extends JpaRepository<Seat, BigInteger> {
}

package com.codefactory.reserva_b.repository;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FlightRepository extends JpaRepository<Flight, BigInteger> {
}

package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IFlightRepository extends JpaRepository<FlightEntityImpl, BigInteger> {
}

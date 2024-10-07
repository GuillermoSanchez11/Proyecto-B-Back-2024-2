package com.codefactory.reserva_b.repository;

import com.codefactory.reserva_b.model.Flight;
import com.codefactory.reserva_b.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, BigInteger> {
    Passenger findPassengerByIdPassenger(BigInteger id);
}

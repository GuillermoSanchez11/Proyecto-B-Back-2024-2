package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;

import java.math.BigInteger;
import java.util.List;

public interface ISeatRepository {
    List<SeatEntityImpl> findAllAvailableSeats(BigInteger idFlight);
}

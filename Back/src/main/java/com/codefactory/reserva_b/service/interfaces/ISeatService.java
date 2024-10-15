package com.codefactory.reserva_b.service.interfaces;

import com.codefactory.reserva_b.dto.impl.SeatResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;

import java.math.BigInteger;
import java.util.List;

public interface ISeatService {
    List<SeatResponseDTOImpl> findAllAvailableSeats(String idFlight);
}

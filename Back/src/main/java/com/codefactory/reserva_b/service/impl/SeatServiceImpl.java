package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ISeatRepository;
import com.codefactory.reserva_b.service.interfaces.ISeatService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class SeatServiceImpl implements ISeatService {
    @Autowired
    private ISeatRepository seatRepository;

    @Override
    public List<SeatEntityImpl> findAllAvailableSeats(String idFlight) {
        return seatRepository.findAllAvailableSeats(new BigInteger(idFlight));
    }
}

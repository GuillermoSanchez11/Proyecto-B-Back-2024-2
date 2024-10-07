package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Booking;
import com.codefactory.reserva_b.model.Seat;
import com.codefactory.reserva_b.repository.SeatRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Seat> getAvailableSeats(String idFlight) {
        return entityManager.createNativeQuery("SELECT * FROM seat WHERE id_flight = ? AND is_reserved = false", Seat.class)
                .setParameter(1, Long.parseLong(idFlight))
                .getResultList();
    }
}

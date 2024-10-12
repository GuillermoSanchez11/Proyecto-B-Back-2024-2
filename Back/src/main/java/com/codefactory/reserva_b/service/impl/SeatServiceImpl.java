package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ISeatRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatServiceImpl {
    @Autowired
    private ISeatRepository seatRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<SeatEntityImpl> getAvailableSeats(String idFlight) {
        return entityManager.createNativeQuery("SELECT * FROM seat WHERE id_flight = ? AND is_reserved = false", SeatEntityImpl.class)
                .setParameter(1, Long.parseLong(idFlight))
                .getResultList();
    }
}

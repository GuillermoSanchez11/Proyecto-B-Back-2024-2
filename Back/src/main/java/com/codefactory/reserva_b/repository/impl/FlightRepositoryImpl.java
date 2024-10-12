package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IFlightRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FlightRepositoryImpl implements IFlightRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<FlightEntityImpl> findAllFlights() {
        TypedQuery<FlightEntityImpl> query = entityManager.createQuery("SELECT f FROM FlightEntityImpl f", FlightEntityImpl.class);
        return query.getResultList();
    }
}

package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ISeatRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public class SeatRepositoryImpl implements ISeatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<SeatEntityImpl> findAllAvailableSeats(BigInteger idFlight){
        TypedQuery<SeatEntityImpl> query = entityManager.createQuery(
                "SELECT s FROM SeatEntityImpl s WHERE s.idFlight = :idFlight AND s.isReserved = false", SeatEntityImpl.class);
        query.setParameter("idFlight", idFlight);
        return query.getResultList();
    }
}

package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IFlightRepository;
import com.codefactory.reserva_b.util.impl.SqlSentencesImpl;
import com.codefactory.reserva_b.util.interfaces.ISqlSentences;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FlightRepositoryImpl implements IFlightRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final ISqlSentences sentences = new SqlSentencesImpl();

    @Transactional
    @Override
    public List<FlightEntityImpl> findAllFlights() {
        List<FlightEntityImpl> flights = entityManager.createNativeQuery(sentences.selectAllFlightsSentence(), FlightEntityImpl.class)
                .getResultList();
        return flights;
    }
}

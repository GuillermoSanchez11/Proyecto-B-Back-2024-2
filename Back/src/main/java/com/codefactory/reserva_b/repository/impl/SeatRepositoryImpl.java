package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ISeatRepository;
import com.codefactory.reserva_b.util.impl.SqlSentencesImpl;
import com.codefactory.reserva_b.util.interfaces.ISqlSentences;
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

    private final ISqlSentences sentences = new SqlSentencesImpl();

    @Transactional
    @Override
    public List<SeatEntityImpl> findAllAvailableSeats(BigInteger idFlight){
        List<SeatEntityImpl> seats = entityManager.createNativeQuery(sentences.selectAllSeatsSentence(), SeatEntityImpl.class)
                .setParameter(1, idFlight)
                .getResultList();
        return seats;
    }
}

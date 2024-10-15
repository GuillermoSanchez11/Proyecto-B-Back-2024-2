package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ILuggageRepository;
import com.codefactory.reserva_b.util.impl.SqlSentencesImpl;
import com.codefactory.reserva_b.util.interfaces.ISqlSentences;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
public class LuggageRepositoryImpl implements ILuggageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final ISqlSentences sentences = new SqlSentencesImpl();

    @Override
    @Transactional
    public LuggageEntityImpl createLuggage(LuggageRequestDTOImpl luggage) {
        PassengerEntityImpl passenger = (PassengerEntityImpl) entityManager.createNativeQuery(
                        sentences.selectPassengerByIdPassengerSentence(),
                        PassengerEntityImpl.class)
                .setParameter(1, luggage.getIdPassenger())
                .getSingleResult();
        System.out.println(luggage);
        System.out.println(luggage.getIdPassenger());
        if (Boolean.FALSE.equals(passenger.getLuggageIncluded())) {
            entityManager.createNativeQuery(sentences.updateLuggageIncludedSentence())
                    .setParameter(1, true)
                    .setParameter(2, luggage.getIdPassenger())
                    .executeUpdate();
        }
        LuggageEntityImpl newLuggage = (LuggageEntityImpl) entityManager.createNativeQuery(sentences.insertLuggageSentence(), LuggageEntityImpl.class)
                .setParameter(1, luggage.getIdPassenger())
                .setParameter(2, luggage.getType())
                .setParameter(3, luggage.getHeightCm())
                .setParameter(4, luggage.getWeightKg())
                .setParameter(5, luggage.getWidthCm())
                .setParameter(6, luggage.getExtraFree())
                .getSingleResult();
        return newLuggage;
    }

    @Override
    @Transactional
    public LuggageEntityImpl editLuggage(BigInteger idLuggage, LuggageRequestDTOImpl luggage) {
        LuggageEntityImpl updatedLuggage = (LuggageEntityImpl) entityManager.createNativeQuery(sentences.updateLuggageInfoSentence(), LuggageEntityImpl.class)
                .setParameter(1, luggage.getType())
                .setParameter(2, luggage.getHeightCm())
                .setParameter(3, luggage.getWeightKg())
                .setParameter(4, luggage.getWidthCm())
                .setParameter(5, luggage.getExtraFree())
                .setParameter(6, idLuggage)
                .getSingleResult();
        return updatedLuggage;
    }

    @Override
    @Transactional
    public PassengerEntityImpl deleteLuggage(BigInteger idPassenger, BigInteger idLuggage) {
        Long luggageCount = (Long) entityManager.createNativeQuery(sentences.selectLuggageCountByIdPassengerSentence())
                .setParameter(1, idPassenger)
                .getSingleResult();
        if (luggageCount <= 0) {
            entityManager.createNativeQuery(sentences.updateLuggageIncludedSentence())
                    .setParameter(1, false)
                    .setParameter(2, idPassenger)
                    .executeUpdate();
        }
        entityManager.createNativeQuery(sentences.deleteLuggageSentence())
                .setParameter(1, idLuggage)
                .executeUpdate();
        PassengerEntityImpl passenger = (PassengerEntityImpl) entityManager.createNativeQuery(sentences.selectPassengerByIdPassengerSentence(), PassengerEntityImpl.class)
                .setParameter(1, idPassenger)
                .getSingleResult();

        return passenger;
    }
}

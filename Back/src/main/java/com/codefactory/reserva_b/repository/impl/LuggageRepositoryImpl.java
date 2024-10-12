package com.codefactory.reserva_b.repository.impl;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.ILuggageRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
public class LuggageRepositoryImpl implements ILuggageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public LuggageEntityImpl addLuggage(BigInteger idPassenger, LuggageEntityImpl luggage) {
        // Verificar si el pasajero ya tiene equipaje incluido
        PassengerEntityImpl passenger = entityManager.createQuery(
                        "SELECT p FROM PassengerEntityImpl p WHERE p.idPassenger = :idPassenger", PassengerEntityImpl.class)
                .setParameter("idPassenger", idPassenger)
                .getSingleResult();

        if (Boolean.FALSE.equals(passenger.getLuggageIncluded())) {
            // Si no tiene equipaje incluido, actualizarlo
            entityManager.createQuery("UPDATE PassengerEntityImpl p SET p.luggageIncluded = true WHERE p.idPassenger = :idPassenger")
                    .setParameter("idPassenger", idPassenger)
                    .executeUpdate();
        }

        // Agregar el nuevo equipaje
        luggage.setIdPassenger(idPassenger);
        entityManager.persist(luggage);

        return luggage;
    }

    @Override
    @Transactional
    public LuggageEntityImpl editLuggage(BigInteger idLuggage, LuggageEntityImpl luggage) {
        // Actualizar los datos del equipaje
        entityManager.createQuery("UPDATE LuggageEntityImpl l SET l.type = :type, l.heightCm = :heightCm, l.weightKg = :weightKg, l.widthCm = :widthCm, l.extraFree = :extraFree WHERE l.idLuggage = :idLuggage")
                .setParameter("type", luggage.getType())
                .setParameter("heightCm", luggage.getHeightCm())
                .setParameter("weightKg", luggage.getWeightKg())
                .setParameter("widthCm", luggage.getWidthCm())
                .setParameter("extraFree", luggage.getExtraFree())
                .setParameter("idLuggage", idLuggage)
                .executeUpdate();

        return luggage;
    }

    @Override
    @Transactional
    public PassengerEntityImpl deleteLuggage(BigInteger idPassenger, BigInteger idLuggage) {
        // Verificar cuántos equipajes tiene el pasajero
        long luggageCount = entityManager.createQuery(
                        "SELECT COUNT(l) FROM LuggageEntityImpl l WHERE l.idPassenger = :idPassenger", Long.class)
                .setParameter("idPassenger", idPassenger)
                .getSingleResult();

        // Si tiene solo uno o ningún equipaje, actualizar la bandera luggage_included
        if (luggageCount <= 1) {
            entityManager.createQuery("UPDATE PassengerEntityImpl p SET p.luggageIncluded = false WHERE p.idPassenger = :idPassenger")
                    .setParameter("idPassenger", idPassenger)
                    .executeUpdate();
        }

        // Eliminar el equipaje
        entityManager.createQuery("DELETE FROM LuggageEntityImpl l WHERE l.idLuggage = :idLuggage")
                .setParameter("idLuggage", idLuggage)
                .executeUpdate();

        // Retornar el pasajero actualizado
        return entityManager.createQuery(
                        "SELECT p FROM PassengerEntityImpl p WHERE p.idPassenger = :idPassenger", PassengerEntityImpl.class)
                .setParameter("idPassenger", idPassenger)
                .getSingleResult();
    }
}

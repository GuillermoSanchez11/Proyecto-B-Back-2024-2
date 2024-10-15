package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;

import java.math.BigInteger;

public interface ILuggageRepository {
    LuggageEntityImpl createLuggage(LuggageRequestDTOImpl luggage);
    LuggageEntityImpl editLuggage(BigInteger idLuggage, LuggageRequestDTOImpl luggage);
    PassengerEntityImpl deleteLuggage(BigInteger idPassenger, BigInteger idLuggage);
}

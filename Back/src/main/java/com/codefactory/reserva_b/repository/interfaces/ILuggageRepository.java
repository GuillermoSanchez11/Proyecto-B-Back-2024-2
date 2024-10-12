package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;

import java.math.BigInteger;

public interface ILuggageRepository {
    LuggageEntityImpl addLuggage(BigInteger idPassenger, LuggageEntityImpl luggage);
    LuggageEntityImpl editLuggage(BigInteger idLuggage, LuggageEntityImpl luggage);
    PassengerEntityImpl deleteLuggage(BigInteger idPassenger, BigInteger idLuggage);
}

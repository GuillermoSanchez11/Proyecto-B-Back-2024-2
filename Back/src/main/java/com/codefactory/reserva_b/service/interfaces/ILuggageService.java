package com.codefactory.reserva_b.service.interfaces;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;

public interface ILuggageService {
    LuggageEntityImpl addLuggage(LuggageEntityImpl luggage);
    PassengerEntityImpl deleteLuggage(String idPassenger, String idLuggage);
    LuggageEntityImpl editLuggage(String idLuggage, LuggageEntityImpl luggage);
}

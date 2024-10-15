package com.codefactory.reserva_b.service.interfaces;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;

public interface ILuggageService {
    LuggageResponseDTOImpl addLuggage(LuggageRequestDTOImpl luggage);
    PassengerResponseDTOImpl deleteLuggage(String idPassenger, String idLuggage);
    LuggageResponseDTOImpl editLuggage(String idLuggage, LuggageRequestDTOImpl luggage);
}

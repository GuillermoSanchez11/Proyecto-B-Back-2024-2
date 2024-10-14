package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.repository.interfaces.ILuggageRepository;
import com.codefactory.reserva_b.service.interfaces.ILuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LuggageServiceImpl implements ILuggageService {
    @Autowired
    private ILuggageRepository luggageRepository;

    @Override
    public LuggageEntityImpl addLuggage(LuggageEntityImpl luggage) {
        return luggageRepository.createLuggage(luggage);
    }

    @Override
    public PassengerEntityImpl deleteLuggage(String idPassenger, String idLuggage) {
        return luggageRepository.deleteLuggage(new BigInteger(idPassenger), new BigInteger(idLuggage));
    }

    @Override
    public LuggageEntityImpl editLuggage(String idLuggage, LuggageEntityImpl luggage) {
        return luggageRepository.editLuggage(new BigInteger(idLuggage), luggage);
    }
}

package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.repository.interfaces.ILuggageRepository;
import com.codefactory.reserva_b.service.interfaces.ILuggageService;
import com.codefactory.reserva_b.util.interfaces.ILuggageMapper;
import com.codefactory.reserva_b.util.interfaces.IPassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LuggageServiceImpl implements ILuggageService {
    @Autowired
    private ILuggageRepository luggageRepository;
    @Autowired
    private ILuggageMapper luggageMapper;
    @Autowired
    private IPassengerMapper passengerMapper;

    @Override
    public LuggageResponseDTOImpl addLuggage(LuggageRequestDTOImpl luggage) {
        LuggageEntityImpl newLuggage = luggageRepository.createLuggage(luggage);
        return luggageMapper.mapLuggageEntityToLuggageResponseDTO(newLuggage);
    }

    @Override
    public PassengerResponseDTOImpl deleteLuggage(String idPassenger, String idLuggage) {
        PassengerEntityImpl passenger = luggageRepository.deleteLuggage(new BigInteger(idPassenger), new BigInteger(idLuggage));
        return passengerMapper.mapPassengerEntityToPassengerResponseDTO(passenger);
    }

    @Override
    public LuggageResponseDTOImpl editLuggage(String idLuggage, LuggageRequestDTOImpl luggage) {
        LuggageEntityImpl editLuggage = luggageRepository.editLuggage(new BigInteger(idLuggage), luggage);
        return luggageMapper.mapLuggageEntityToLuggageResponseDTO(editLuggage);
    }
}

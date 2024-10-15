package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPassengerResponseDTO;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.IPassengerEntity;

import java.util.List;

public interface IPassengerMapper {
    List<PassengerResponseDTOImpl> mapPassengerEntitiesToPassengerResponseDTOs(List<PassengerEntityImpl> passengerEntities);
    PassengerResponseDTOImpl mapPassengerEntityToPassengerResponseDTO(IPassengerEntity passengerEntity);
}

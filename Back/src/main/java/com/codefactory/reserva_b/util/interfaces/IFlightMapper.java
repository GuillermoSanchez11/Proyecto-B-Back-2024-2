package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.FlightResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.IFlightEntity;

import java.util.List;

public interface IFlightMapper {
    FlightResponseDTOImpl mapFlightEntityToFlightResponseDTO(IFlightEntity flightEntity);
    List<FlightResponseDTOImpl> mapFlightEntitiesToFlightResponseDTOs(List<FlightEntityImpl> flightEntities);
}

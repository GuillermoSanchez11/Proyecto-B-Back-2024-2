package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.SeatResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ISeatResponseDTO;
import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.ISeatEntity;

import java.util.List;

public interface ISeatMapper {
    SeatResponseDTOImpl mapSeatEntityToSeatResponseDTO(ISeatEntity seatEntity);
    List<SeatResponseDTOImpl> mapSeatEntitiesToSeatResponseDTOs(List<SeatEntityImpl> seatEntities);
}

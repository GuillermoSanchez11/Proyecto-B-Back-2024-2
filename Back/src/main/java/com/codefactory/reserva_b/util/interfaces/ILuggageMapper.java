package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ILuggageResponseDTO;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.ILuggageEntity;

import java.util.List;

public interface ILuggageMapper {
    LuggageResponseDTOImpl mapLuggageEntityToLuggageResponseDTO(ILuggageEntity luggageEntity);
    List<LuggageResponseDTOImpl> mapLuggageEntitiesToLuggageResponseDTOs(List<LuggageEntityImpl> luggageEntities);
}

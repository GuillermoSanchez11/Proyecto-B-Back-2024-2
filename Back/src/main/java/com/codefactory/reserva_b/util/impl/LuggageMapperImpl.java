package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ILuggageResponseDTO;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.ILuggageEntity;
import com.codefactory.reserva_b.util.interfaces.ILuggageMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LuggageMapperImpl implements ILuggageMapper {
    @Override
    public LuggageResponseDTOImpl mapLuggageEntityToLuggageResponseDTO(ILuggageEntity luggageEntity) {
        if (luggageEntity == null) {
            return null;
        }

        Long idLuggage = luggageEntity.getIdLuggage().longValue();
        Long idPassenger = luggageEntity.getIdPassenger().longValue();
        String type = luggageEntity.getType();
        Float heightCm = luggageEntity.getHeightCm() != null ? luggageEntity.getHeightCm().floatValue() : null;
        Float weightKg = luggageEntity.getWeightKg() != null ? luggageEntity.getWeightKg().floatValue() : null;
        Float widthCm = luggageEntity.getWidthCm() != null ? luggageEntity.getWidthCm().floatValue() : null;
        Float extraFree = luggageEntity.getExtraFree() != null ? luggageEntity.getExtraFree().floatValue() : null;

        return new LuggageResponseDTOImpl(
                idLuggage,
                idPassenger,
                type,
                heightCm,
                weightKg,
                widthCm,
                extraFree
        );
    }

    public List<LuggageResponseDTOImpl> mapLuggageEntitiesToLuggageResponseDTOs(List<LuggageEntityImpl> luggageEntities) {
        if (luggageEntities == null) {
            return null;
        }
        return luggageEntities.stream()
                .map(this::mapLuggageEntityToLuggageResponseDTO)
                .collect(Collectors.toList());
    }
}

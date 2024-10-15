package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.CityResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ICityResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.ICityEntity;

public interface ICityMapper {
    CityResponseDTOImpl mapCityEntityToCityResponseDTO(ICityEntity cityEntity);
}

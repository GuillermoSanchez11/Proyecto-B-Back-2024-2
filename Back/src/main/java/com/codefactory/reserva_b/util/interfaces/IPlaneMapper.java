package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.PlaneResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPlaneResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPlaneEntity;

public interface IPlaneMapper {
    PlaneResponseDTOImpl mapPlaneEntityToPlaneResponseDTO(IPlaneEntity planeEntity);
}

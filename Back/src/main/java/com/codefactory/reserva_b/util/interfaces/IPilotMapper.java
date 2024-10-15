package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.PilotResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPilotResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPilotEntity;

public interface IPilotMapper {
    PilotResponseDTOImpl mapPilotEntityToPilotResponseDTO(IPilotEntity pilotEntity);
}

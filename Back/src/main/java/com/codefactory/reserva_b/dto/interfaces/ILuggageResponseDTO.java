package com.codefactory.reserva_b.dto.interfaces;

public interface ILuggageResponseDTO {
    Long getIdLuggage();
    Long getIdPassenger();
    String getType();
    Float getHeightCm();
    Float getWeightKg();
    Float getWidthCm();
    Float getExtraFree();
}

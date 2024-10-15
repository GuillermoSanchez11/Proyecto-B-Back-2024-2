package com.codefactory.reserva_b.dto.interfaces;

public interface ILuggageRequestDTO {
    Long getIdPassenger();
    String getType();
    Float getHeightCm();
    Float getWeightKg();
    Float getWidthCm();
    Float getExtraFree();
}

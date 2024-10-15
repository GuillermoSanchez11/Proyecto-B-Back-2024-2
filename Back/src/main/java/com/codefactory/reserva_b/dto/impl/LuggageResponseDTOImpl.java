package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.ILuggageResponseDTO;

public class LuggageResponseDTOImpl implements ILuggageResponseDTO {
    private final Long idLuggage;
    private final Long idPassenger;
    private final String type;
    private final Float heightCm;
    private final Float weightKg;
    private final Float widthCm;
    private final Float extraFree;

    public LuggageResponseDTOImpl(Long idLuggage, Long idPassenger, String type, Float heightCm,
                                  Float weightKg, Float widthCm, Float extraFree) {
        this.idLuggage = idLuggage;
        this.idPassenger = idPassenger;
        this.type = type;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.widthCm = widthCm;
        this.extraFree = extraFree;
    }

    @Override
    public Long getIdLuggage() {
        return idLuggage;
    }

    @Override
    public Long getIdPassenger() {
        return idPassenger;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Float getHeightCm() {
        return heightCm;
    }

    @Override
    public Float getWeightKg() {
        return weightKg;
    }

    @Override
    public Float getWidthCm() {
        return widthCm;
    }

    @Override
    public Float getExtraFree() {
        return extraFree;
    }
}

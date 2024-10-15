package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.ILuggageRequestDTO;

public class LuggageRequestDTOImpl implements ILuggageRequestDTO {
    private final Long idPassenger;
    private final String type;
    private final Float heightCm;
    private final Float weightKg;
    private final Float widthCm;
    private final Float extraFree;

    public LuggageRequestDTOImpl(Long idPassenger, String type, Float heightCm,
                                 Float weightKg, Float widthCm, Float extraFree) {
        this.idPassenger = idPassenger;
        this.type = type;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.widthCm = widthCm;
        this.extraFree = extraFree;
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

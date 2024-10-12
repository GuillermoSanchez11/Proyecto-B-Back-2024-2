package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigInteger;

public interface ILuggageEntity {
    // Getters
    BigInteger getIdLuggage();
    BigInteger getIdPassenger();
    Double getHeightCm();
    String getType();
    Double getWeightKg();
    Double getWidthCm();
    Double getExtraFree();

    // Setters
    void setIdLuggage(BigInteger idLuggage);
    void setIdPassenger(BigInteger idPassenger);
    void setHeightCm(Double heightCm);
    void setType(String type);
    void setWeightKg(Double weightKg);
    void setWidthCm(Double widthCm);
    void setExtraFree(Double extraFree);
}

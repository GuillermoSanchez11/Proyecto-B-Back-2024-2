package com.codefactory.reserva_b.entity.impl;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import com.codefactory.reserva_b.entity.interfaces.ILuggageEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "luggage")
public class LuggageEntityImpl implements ILuggageEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_luggage")
    private BigInteger idLuggage;

    @Column(name = "id_passenger", nullable = false)
    private BigInteger idPassenger;

    @Column(name = "type")
    private String type;

    @Column(name = "height_cm", nullable = false)
    private Double heightCm;

    @Column(name = "weight_kg", nullable = false)
    private Double weightKg;

    @Column(name = "width_cm", nullable = false)
    private Double widthCm;

    @Column(name = "extra_free")
    private Double extraFree;

    // Constructor
    public LuggageEntityImpl(BigInteger idPassenger, String type, Double heightCm, Double weightKg, Double widthCm, Double extraFree) {
        this.idPassenger = idPassenger;
        this.type = type;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.widthCm = widthCm;
        this.extraFree = extraFree;
    }

    public LuggageEntityImpl() {
    }

    public BigInteger getIdLuggage() {
        return idLuggage;
    }

    public void setIdLuggage(BigInteger idLuggage) {
        this.idLuggage = idLuggage;
    }

    public BigInteger getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(BigInteger idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(Double widthCm) {
        this.widthCm = widthCm;
    }

    public Double getExtraFree() {
        return extraFree;
    }

    public void setExtraFree(Double extraFree) {
        this.extraFree = extraFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LuggageEntityImpl that = (LuggageEntityImpl) o;
        return Objects.equals(idLuggage, that.idLuggage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idLuggage);
    }

    @Override
    public String toString() {
        return "LuggageEntityImpl{" +
                "idLuggage=" + idLuggage +
                ", idPassenger=" + idPassenger +
                ", type='" + type + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", widthCm=" + widthCm +
                ", extraFree=" + extraFree +
                '}';
    }
}

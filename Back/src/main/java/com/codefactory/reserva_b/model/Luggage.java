package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "luggage")
public class Luggage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_luggage")
    private Long idLuggage;

    @Column(name = "id_passenger", nullable = false)
    private Long passenger;  // Relación con Passenger

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "height_cm", nullable = false)
    private Double heightCm;

    @Column(name = "weight_kg", nullable = false)
    private Double weightKg;

    @Column(name = "width_cm", nullable = false)
    private Double widthCm;

    @Column(name = "extra_free", nullable = false)
    private Double extraFree;

    // Constructor
    public Luggage(Long idLuggage, Long passenger, String type, Double heightCm,
                   Double weightKg, Double widthCm, Double extraFree) {
        this.idLuggage = idLuggage;
        this.passenger = passenger;
        this.type = type;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.widthCm = widthCm;
        this.extraFree = extraFree;
    }

    public Luggage() {

    }


    // Getters y Setters

    public Long getIdLuggage() {
        return idLuggage;
    }

    public void setIdLuggage(Long idLuggage) {
        this.idLuggage = idLuggage;
    }

    public Long  getPassenger() {
        return passenger;
    }

    public void setPassenger(Long passenger) {
        this.passenger = passenger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
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

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Luggage luggage)) return false;
        return Objects.equals(idLuggage, luggage.idLuggage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLuggage);
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "idLuggage=" + idLuggage +
                ", passenger=" + passenger +
                ", type='" + type + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", widthCm=" + widthCm +
                ", extraFree=" + extraFree +
                '}';
    }
}

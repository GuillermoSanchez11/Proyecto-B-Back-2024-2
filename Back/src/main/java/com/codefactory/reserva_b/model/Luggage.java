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

    @ManyToOne
    @JoinColumn(name = "id_passanger", nullable = false)
    private Passenger passenger;  // Relación con Passenger

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "weight", nullable = false)
    private double weight;

    // Constructor por defecto
    public Luggage() {
    }

    // Constructor con todos los campos
    public Luggage(Long idLuggage, Passenger passenger, String type, double height, double width, double weight) {
        this.idLuggage = idLuggage;
        this.passenger = passenger;
        this.type = type;
        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    // Getters y Setters
    public Long getIdLuggage() {
        return idLuggage;
    }

    public void setIdLuggage(Long idLuggage) {
        this.idLuggage = idLuggage;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
                ", height=" + height +
                ", width=" + width +
                ", weight=" + weight +
                '}';
    }
}

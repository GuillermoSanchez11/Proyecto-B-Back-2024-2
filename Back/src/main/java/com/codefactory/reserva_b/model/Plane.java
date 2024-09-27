package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "plane")
public class Plane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plane")
    private Long idPlane;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "capacity_max", nullable = false)
    private int capacity;

    // Constructor por defecto
    public Plane() {
    }

    // Constructor con todos los campos
    public Plane(Long idPlane, String model, int capacity) {
        this.idPlane = idPlane;
        this.model = model;
        this.capacity = capacity;
    }

    // Getters y Setters
    public Long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane plane)) return false;
        return Objects.equals(idPlane, plane.idPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlane);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "idPlane=" + idPlane +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
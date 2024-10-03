package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "capacity_economy", nullable = false)
    private Long capacityEconomy;

    @Column(name = "capacity_business", nullable = false)
    private Long capacityBusiness;

    @Column(name = "capacity_first_class", nullable = false)
    private Long capacityFirstClass;

    @Column(name = "date_manufactured", nullable = false)
    private LocalDate dateManufactured;

    @Column(name = "last_maintenance_date", nullable = false)
    private LocalDate lastMaintenanceDate;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "fuel_capacity", nullable = false)
    private Double fuelCapacity;

    // Constructor
    public Plane(Long idPlane, String model, String manufacturer, Long capacityEconomy,
                 Long capacityBusiness, Long capacityFirstClass, LocalDate dateManufactured,
                 LocalDate lastMaintenanceDate, String registrationNumber, Double fuelCapacity) {
        this.idPlane = idPlane;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacityEconomy = capacityEconomy;
        this.capacityBusiness = capacityBusiness;
        this.capacityFirstClass = capacityFirstClass;
        this.dateManufactured = dateManufactured;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.registrationNumber = registrationNumber;
        this.fuelCapacity = fuelCapacity;
    }

    public Plane() {

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getCapacityEconomy() {
        return capacityEconomy;
    }

    public void setCapacityEconomy(Long capacityEconomy) {
        this.capacityEconomy = capacityEconomy;
    }

    public Long getCapacityBusiness() {
        return capacityBusiness;
    }

    public void setCapacityBusiness(Long capacityBusiness) {
        this.capacityBusiness = capacityBusiness;
    }

    public Long getCapacityFirstClass() {
        return capacityFirstClass;
    }

    public void setCapacityFirstClass(Long capacityFirstClass) {
        this.capacityFirstClass = capacityFirstClass;
    }

    public LocalDate getDateManufactured() {
        return dateManufactured;
    }

    public void setDateManufactured(LocalDate dateManufactured) {
        this.dateManufactured = dateManufactured;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
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
                ", manufacturer='" + manufacturer + '\'' +
                ", capacityEconomy=" + capacityEconomy +
                ", capacityBusiness=" + capacityBusiness +
                ", capacityFirstClass=" + capacityFirstClass +
                ", dateManufactured=" + dateManufactured +
                ", lastMaintenanceDate=" + lastMaintenanceDate +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}
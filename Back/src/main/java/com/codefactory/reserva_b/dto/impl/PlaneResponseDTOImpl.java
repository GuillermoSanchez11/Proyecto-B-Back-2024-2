package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IPlaneResponseDTO;

import java.time.LocalDate;

public class PlaneResponseDTOImpl implements IPlaneResponseDTO {
    private final Long idPlane;
    private final String model;
    private final String manufacturer;
    private final Integer capacityEconomy;
    private final Integer capacityBusiness;
    private final Integer capacityFirstClass;
    private final LocalDate dateManufactured;
    private final LocalDate lastMaintenanceDate;
    private final String registrationNumber;
    private final Float fuelCapacity;

    public PlaneResponseDTOImpl(Long idPlane, String model, String manufacturer, Integer capacityEconomy,
                                Integer capacityBusiness, Integer capacityFirstClass, LocalDate dateManufactured,
                                LocalDate lastMaintenanceDate, String registrationNumber, Float fuelCapacity) {
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

    @Override
    public Long getIdPlane() {
        return idPlane;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public Integer getCapacityEconomy() {
        return capacityEconomy;
    }

    @Override
    public Integer getCapacityBusiness() {
        return capacityBusiness;
    }

    @Override
    public Integer getCapacityFirstClass() {
        return capacityFirstClass;
    }

    @Override
    public LocalDate getDateManufactured() {
        return dateManufactured;
    }

    @Override
    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public Float getFuelCapacity() {
        return fuelCapacity;
    }
}

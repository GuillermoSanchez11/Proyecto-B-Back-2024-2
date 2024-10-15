package com.codefactory.reserva_b.dto.interfaces;

import java.time.LocalDate;

public interface IPlaneResponseDTO {
    Long getIdPlane();
    String getModel();
    String getManufacturer();
    Integer getCapacityEconomy();
    Integer getCapacityBusiness();
    Integer getCapacityFirstClass();
    LocalDate getDateManufactured();
    LocalDate getLastMaintenanceDate();
    String getRegistrationNumber();
    Float getFuelCapacity();
}

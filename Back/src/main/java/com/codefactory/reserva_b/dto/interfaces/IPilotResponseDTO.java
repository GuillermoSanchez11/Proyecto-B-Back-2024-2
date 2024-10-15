package com.codefactory.reserva_b.dto.interfaces;

import java.time.LocalDate;

public interface IPilotResponseDTO {
    Long getIdPilot();
    String getFirstName();
    String getLastName();
    String getLicenseNumber();
    LocalDate getDateOfBirth();
    String getNationality();
    String getRank();
    Float getHoursFlown();
    LocalDate getEmployeeDate();
    String getStatus();
    String getHomeBase();
    LocalDate getLastMedicalCheck();
}

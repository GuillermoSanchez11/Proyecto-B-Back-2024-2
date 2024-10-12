package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigInteger;
import java.time.LocalDate;

public interface IPilotEntity {
    // Getters
    BigInteger getIdPilot();
    String getFirstName();
    String getLastName();
    String getLicenseNumber();
    LocalDate getDateOfBirth();
    String getNationality();
    String getRank();
    Double getHoursFlown();
    LocalDate getEmployeeDate();
    String getStatus();
    String getHomeBase();
    LocalDate getLastMedicalCheck();

    // Setters
    void setIdPilot(BigInteger idPilot);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setLicenseNumber(String licenseNumber);
    void setDateOfBirth(LocalDate dateOfBirth);
    void setNationality(String nationality);
    void setRank(String rank);
    void setHoursFlown(Double hoursFlown);
    void setEmployeeDate(LocalDate employeeDate);
    void setStatus(String status);
    void setHomeBase(String homeBase);
    void setLastMedicalCheck(LocalDate lastMedicalCheck);
}

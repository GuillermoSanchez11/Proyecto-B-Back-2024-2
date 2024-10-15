package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IPilotResponseDTO;

import java.time.LocalDate;

public class PilotResponseDTOImpl implements IPilotResponseDTO {
    private final Long idPilot;
    private final String firstName;
    private final String lastName;
    private final String licenseNumber;
    private final LocalDate dateOfBirth;
    private final String nationality;
    private final String rank;
    private final Float hoursFlown;
    private final LocalDate employeeDate;
    private final String status;
    private final String homeBase;
    private final LocalDate lastMedicalCheck;

    public PilotResponseDTOImpl(Long idPilot, String firstName, String lastName, String licenseNumber,
                                LocalDate dateOfBirth, String nationality, String rank, Float hoursFlown,
                                LocalDate employeeDate, String status, String homeBase, LocalDate lastMedicalCheck) {
        this.idPilot = idPilot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.rank = rank;
        this.hoursFlown = hoursFlown;
        this.employeeDate = employeeDate;
        this.status = status;
        this.homeBase = homeBase;
        this.lastMedicalCheck = lastMedicalCheck;
    }

    @Override
    public Long getIdPilot() {
        return idPilot;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public Float getHoursFlown() {
        return hoursFlown;
    }

    @Override
    public LocalDate getEmployeeDate() {
        return employeeDate;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getHomeBase() {
        return homeBase;
    }

    @Override
    public LocalDate getLastMedicalCheck() {
        return lastMedicalCheck;
    }
}

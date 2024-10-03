package com.codefactory.reserva_b.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pilot")
public class Pilot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pilot")
    private Long idPilot;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "license_number", nullable = false)
    private String licenseNumber;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "rank", nullable = false)
    private String rank;

    @Column(name = "hours_flown", nullable = false)
    private Double hoursFlown;

    @Column(name = "employee_date", nullable = false)
    private LocalDate employeeDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "home_base", nullable = false)
    private String homeBase;

    @Column(name = "last_medical_check", nullable = false)
    private LocalDate lastMedicalCheck;

    // Constructor
    public Pilot(Long idPilot, String firstName, String lastName, String licenseNumber,
                 LocalDate dateOfBirth, String nationality, String rank,
                 Double hoursFlown, LocalDate employeeDate, String status,
                 String homeBase, LocalDate lastMedicalCheck) {
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

    public Pilot() {

    }


    // Getters y Setters

    public Long getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(Long idPilot) {
        this.idPilot = idPilot;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Double getHoursFlown() {
        return hoursFlown;
    }

    public void setHoursFlown(Double hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    public LocalDate getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(LocalDate employeeDate) {
        this.employeeDate = employeeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(String homeBase) {
        this.homeBase = homeBase;
    }

    public LocalDate getLastMedicalCheck() {
        return lastMedicalCheck;
    }

    public void setLastMedicalCheck(LocalDate lastMedicalCheck) {
        this.lastMedicalCheck = lastMedicalCheck;
    }

    // equals, hashCode y toString


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot pilot)) return false;

        return Objects.equals(idPilot, pilot.idPilot);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPilot);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "idPilot=" + idPilot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", rank='" + rank + '\'' +
                ", hoursFlown=" + hoursFlown +
                ", employeeDate=" + employeeDate +
                ", status='" + status + '\'' +
                ", homeBase='" + homeBase + '\'' +
                ", lastMedicalCheck=" + lastMedicalCheck +
                '}';
    }
}
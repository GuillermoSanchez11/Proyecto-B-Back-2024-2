package com.codefactory.reserva_b.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private BigInteger idUser;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "flyer_number", nullable = false)
    private Long flyerNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    // Constructor por defecto
    public Users() {
    }

    // Constructor con todos los campos
    public Users(BigInteger idUser, String firstName, String lastName, String phoneNumber, String email,
                 String nationality, LocalDate dateOfBirth, String documentId, String passportNumber,
                 LocalDate registrationDate, Long flyerNumber, String address, String userType, String passwordHash) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.documentId = documentId;
        this.passportNumber = passportNumber;
        this.registrationDate = registrationDate;
        this.flyerNumber = flyerNumber;
        this.address = address;
        this.userType = userType;
        this.passwordHash = passwordHash;
    }

    // Getters y Setters


    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getFlyerNumber() {
        return flyerNumber;
    }

    public void setFlyerNumber(Long flyerNumber) {
        this.flyerNumber = flyerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users user)) return false;
        return Objects.equals(idUser, user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", documentId='" + documentId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", registrationDate=" + registrationDate +
                ", flyerNumber=" + flyerNumber +
                ", address='" + address + '\'' +
                ", userType='" + userType + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}

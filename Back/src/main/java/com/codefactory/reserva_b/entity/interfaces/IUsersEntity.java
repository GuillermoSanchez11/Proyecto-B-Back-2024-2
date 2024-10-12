package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigInteger;
import java.time.LocalDate;

public interface IUsersEntity {
    // Getters
    BigInteger getIdUser();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getEmail();
    String getNationality();
    String getDocumentId();
    LocalDate getDateOfBirth();
    String getPassportNumber();
    LocalDate getRegistrationDate();
    Long getFlyerNumber();
    String getAddress();
    String getUserType();

    // Setters
    void setIdUser(BigInteger idUser);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setPhoneNumber(String phoneNumber);
    void setEmail(String email);
    void setNationality(String nationality);
    void setDocumentId(String documentId);
    void setDateOfBirth(LocalDate dateOfBirth);
    void setPassportNumber(String passportNumber);
    void setRegistrationDate(LocalDate registrationDate);
    void setFlyerNumber(Long flyerNumber);
    void setAddress(String address);
    void setUserType(String userType);
}

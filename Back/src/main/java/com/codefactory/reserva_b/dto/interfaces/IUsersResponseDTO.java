package com.codefactory.reserva_b.dto.interfaces;

public interface IUsersResponseDTO {
    Long getIdUser();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getEmail();
    String getNationality();
    String getDateOfBirth();
    String getDocumentId();
    String getPassportNumber();
    String getRegistrationDate();
    Integer getFlyerNumber();
    String getAddress();
    String getUserType();
}

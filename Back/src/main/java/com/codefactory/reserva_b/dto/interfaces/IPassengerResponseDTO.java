package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;

import java.util.List;

public interface IPassengerResponseDTO {
    Long getIdPassenger();
    Long getIdSeat();
    ISeatResponseDTO getSeat();
    String getFirstName();
    String getLastName();
    String getDateOfBirth();
    String getDocumentId();
    String getPassportNumber();
    String getNationality();
    String getSpecialRequests();
    Boolean getLuggageIncluded();
    List<LuggageResponseDTOImpl> getLuggage();
}

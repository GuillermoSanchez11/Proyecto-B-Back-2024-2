package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;

import java.util.List;

public interface IPassengerRequestDTO {
    Long getIdSeat();
    String getFirstName();
    String getLastName();
    String getDateOfBirth();
    String getDocumentId();
    String getPassportNumber();
    String getNationality();
    String getSpecialRequests();
    Boolean getLuggageIncluded();
    List<LuggageRequestDTOImpl> getLuggage();
}

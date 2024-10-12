package com.codefactory.reserva_b.entity.interfaces;

import com.codefactory.reserva_b.entity.impl.LuggageEntityImpl;
import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface IPassengerEntity {
    // Getters
    BigInteger getIdPassenger();
    BigInteger getIdSeat();
    SeatEntityImpl getSeat();
    String getFirstName();
    LocalDate getDateOfBirth();
    String getLastName();
    String getDocumentId();
    String getPassportNumber();
    String getNationality();
    String getSpecialRequests();
    Boolean getLuggageIncluded();
    List<LuggageEntityImpl> getLuggage();

    // Setters
    void setIdPassenger(BigInteger idPassenger);
    void setIdSeat(BigInteger idSeat);
    void setSeat(SeatEntityImpl seat);
    void setFirstName(String firstName);
    void setDateOfBirth(LocalDate dateOfBirth);
    void setLastName(String lastName);
    void setDocumentId(String documentId);
    void setPassportNumber(String passportNumber);
    void setNationality(String nationality);
    void setSpecialRequests(String specialRequests);
    void setLuggageIncluded(Boolean luggageIncluded);
    void setLuggage(List<LuggageEntityImpl> luggage);
}

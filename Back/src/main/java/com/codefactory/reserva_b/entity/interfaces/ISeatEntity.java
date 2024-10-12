package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigInteger;

public interface ISeatEntity {
    // Getters
    BigInteger getIdSeat();
    BigInteger getIdFlight();
    String getSeatNumber();
    Boolean getReserved();
    Double getPrice();
    String getSeatClass();

    // Setters
    void setIdSeat(BigInteger idSeat);
    void setIdFlight(BigInteger idFlight);
    void setSeatNumber(String seatNumber);
    void setReserved(Boolean reserved);
    void setPrice(Double price);
    void setSeatClass(String seatClass);
}

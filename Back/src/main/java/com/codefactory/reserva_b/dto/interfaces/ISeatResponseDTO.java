package com.codefactory.reserva_b.dto.interfaces;

public interface ISeatResponseDTO {
    Long getIdSeat();
    Long getIdFlight();
    String getSeatNumber();
    Boolean getIsReserved();
    Float getPrice();
    String getSeatClass();
}

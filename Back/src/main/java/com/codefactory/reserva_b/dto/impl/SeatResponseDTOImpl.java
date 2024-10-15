package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.ISeatResponseDTO;

public class SeatResponseDTOImpl implements ISeatResponseDTO {
    private final Long idSeat;
    private final Long idFlight;
    private final String seatNumber;
    private final Boolean isReserved;
    private final Float price;
    private final String seatClass;

    public SeatResponseDTOImpl(Long idSeat, Long idFlight, String seatNumber, Boolean isReserved,
                               Float price, String seatClass) {
        this.idSeat = idSeat;
        this.idFlight = idFlight;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
        this.price = price;
        this.seatClass = seatClass;
    }

    @Override
    public Long getIdSeat() {
        return idSeat;
    }

    @Override
    public Long getIdFlight() {
        return idFlight;
    }

    @Override
    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public Boolean getIsReserved() {
        return isReserved;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public String getSeatClass() {
        return seatClass;
    }
}

package com.codefactory.reserva_b.dto.interfaces;

import com.codefactory.reserva_b.dto.impl.CountryResponseDTOImpl;

public interface ICityResponseDTO {
    Long getIdCity();
    String getName();
    Long getCountryId();
    CountryResponseDTOImpl getCountry();
    String getTimezone();
    Float getLatitude();
    Float getLongitude();
}

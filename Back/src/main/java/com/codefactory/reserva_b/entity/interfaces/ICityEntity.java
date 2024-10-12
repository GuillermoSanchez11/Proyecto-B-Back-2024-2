package com.codefactory.reserva_b.entity.interfaces;

import com.codefactory.reserva_b.entity.impl.CountryEntityImpl;

import java.math.BigInteger;

public interface ICityEntity {
    // Getters
    BigInteger getIdCity();
    String getName();
    BigInteger getCountryId();
    CountryEntityImpl getCountry();
    Double getLatitude();
    Double getLongitude();
    String getTimezone();

    // Setters
    void setIdCity(BigInteger idCity);
    void setName(String name);
    void setCountryId(BigInteger countryId);
    void setCountry(CountryEntityImpl country);
    void setLatitude(Double latitude);
    void setLongitude(Double longitude);
    void setTimezone(String timezone);
}

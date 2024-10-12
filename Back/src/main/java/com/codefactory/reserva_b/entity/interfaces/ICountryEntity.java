package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigInteger;

public interface ICountryEntity {
    // Getters
    BigInteger getIdCountry();
    String getName();
    String getContinent();
    String getLanguage();

    // Setters
    void setIdCountry(BigInteger idCountry);
    void setName(String name);
    void setContinent(String continent);
    void setLanguage(String language);
}

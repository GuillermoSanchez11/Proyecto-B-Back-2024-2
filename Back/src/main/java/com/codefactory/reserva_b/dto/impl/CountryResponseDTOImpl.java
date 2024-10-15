package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.ICountryResponseDTO;

public class CountryResponseDTOImpl implements ICountryResponseDTO {
    private final Long idCountry;
    private final String name;
    private final String continent;
    private final String language;

    public CountryResponseDTOImpl(Long idCountry, String name, String continent, String language) {
        this.idCountry = idCountry;
        this.name = name;
        this.continent = continent;
        this.language = language;
    }

    @Override
    public Long getIdCountry() {
        return idCountry;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContinent() {
        return continent;
    }

    @Override
    public String getLanguage() {
        return language;
    }
}

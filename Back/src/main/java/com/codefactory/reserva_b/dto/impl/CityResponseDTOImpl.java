package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.ICityResponseDTO;

public class CityResponseDTOImpl implements ICityResponseDTO {
    private final Long idCity;
    private final String name;
    private final Long countryId;
    private final CountryResponseDTOImpl country;
    private final String timezone;
    private final Float latitude;
    private final Float longitude;

    public CityResponseDTOImpl(Long idCity, String name, Long countryId, CountryResponseDTOImpl country,
                               String timezone, Float latitude, Float longitude) {
        this.idCity = idCity;
        this.name = name;
        this.countryId = countryId;
        this.country = country;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public Long getIdCity() {
        return idCity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getCountryId() {
        return countryId;
    }

    @Override
    public CountryResponseDTOImpl getCountry() {
        return country;
    }

    @Override
    public String getTimezone() {
        return timezone;
    }

    @Override
    public Float getLatitude() {
        return latitude;
    }

    @Override
    public Float getLongitude() {
        return longitude;
    }
}

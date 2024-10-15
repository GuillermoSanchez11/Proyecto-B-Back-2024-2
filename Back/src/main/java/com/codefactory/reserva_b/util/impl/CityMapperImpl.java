package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.CityResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.CountryResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ICityResponseDTO;
import com.codefactory.reserva_b.dto.interfaces.ICountryResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.ICityEntity;
import com.codefactory.reserva_b.util.interfaces.ICityMapper;
import com.codefactory.reserva_b.util.interfaces.ICountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapperImpl implements ICityMapper {
    @Autowired
    private ICountryMapper countryMapper;
    @Override
    public CityResponseDTOImpl mapCityEntityToCityResponseDTO(ICityEntity cityEntity) {
        if (cityEntity == null) {
            return null;
        }

        Long idCity = cityEntity.getIdCity().longValue();
        String name = cityEntity.getName();
        Long countryId = cityEntity.getCountryId() != null ? cityEntity.getCountryId().longValue() : null;
        CountryResponseDTOImpl country = cityEntity.getCountry() != null ?
                countryMapper.mapCountryEntityToCountryResponseDTO(cityEntity.getCountry()) : null;
        String timezone = cityEntity.getTimezone();
        Float latitude = cityEntity.getLatitude() != null ? cityEntity.getLatitude().floatValue() : null;
        Float longitude = cityEntity.getLongitude() != null ? cityEntity.getLongitude().floatValue() : null;

        return new CityResponseDTOImpl(
                idCity,
                name,
                countryId,
                country,
                timezone,
                latitude,
                longitude
        );
    }
}

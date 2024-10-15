package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.CountryResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ICountryResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.ICountryEntity;
import com.codefactory.reserva_b.util.interfaces.ICountryMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryMapperImpl implements ICountryMapper {
    @Override
    public CountryResponseDTOImpl mapCountryEntityToCountryResponseDTO(ICountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }

        Long idCountry = countryEntity.getIdCountry().longValue();
        String name = countryEntity.getName();
        String continent = countryEntity.getContinent();
        String language = countryEntity.getLanguage();

        return new CountryResponseDTOImpl(idCountry, name, continent, language);
    }
}

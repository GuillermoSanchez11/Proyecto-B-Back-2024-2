package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.CountryResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ICountryResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.ICountryEntity;

public interface ICountryMapper {
    CountryResponseDTOImpl mapCountryEntityToCountryResponseDTO(ICountryEntity countryEntity);
}

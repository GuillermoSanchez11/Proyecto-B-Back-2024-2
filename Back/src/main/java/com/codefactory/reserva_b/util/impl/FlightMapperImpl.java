package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.CityResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.FlightResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PilotResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PlaneResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.ICityResponseDTO;
import com.codefactory.reserva_b.dto.interfaces.IPilotResponseDTO;
import com.codefactory.reserva_b.dto.interfaces.IPlaneResponseDTO;
import com.codefactory.reserva_b.entity.impl.FlightEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.IFlightEntity;
import com.codefactory.reserva_b.util.interfaces.ICityMapper;
import com.codefactory.reserva_b.util.interfaces.IFlightMapper;
import com.codefactory.reserva_b.util.interfaces.IPilotMapper;
import com.codefactory.reserva_b.util.interfaces.IPlaneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapperImpl implements IFlightMapper {
    @Autowired
    private IPlaneMapper planeMapper;
    @Autowired
    private ICityMapper cityMapper;
    @Autowired
    private IPilotMapper pilotMapper;
    @Override
    public FlightResponseDTOImpl mapFlightEntityToFlightResponseDTO(IFlightEntity flightEntity) {
        if (flightEntity == null) {
            return null;
        }
        Long idFlight = flightEntity.getIdFlight().longValue();
        String flightNumber = flightEntity.getFlightNumber().toString();
        Long idPlane = flightEntity.getIdPlane().longValue();
        Long idDepartureCity = flightEntity.getIdDepartureCity().longValue();
        Long idArrivalCity = flightEntity.getIdArrivalCity().longValue();
        LocalDateTime departureTime = flightEntity.getDepartureTime();
        LocalDateTime arrivalTime = flightEntity.getArrivalTime();
        String status = flightEntity.getStatus();
        String flightDuration = flightEntity.getFlightDuration();
        Float distanceKm = flightEntity.getDistanceKm().floatValue();
        Integer seats = flightEntity.getSeats();
        Long idCaptain = flightEntity.getIdCaptain().longValue();
        Long idSubCaptain = flightEntity.getIdSubCaptain().longValue();
        Float priceEconomy = flightEntity.getPriceEconomy().floatValue();
        Float priceBusiness = flightEntity.getPriceBusiness().floatValue();
        Float priceFirstClass = flightEntity.getPriceFirstClass().floatValue();
        PlaneResponseDTOImpl plane = flightEntity.getPlane() != null ?
                planeMapper.mapPlaneEntityToPlaneResponseDTO(flightEntity.getPlane()) : null;

        CityResponseDTOImpl departureCity = flightEntity.getDepartureCity() != null ?
                cityMapper.mapCityEntityToCityResponseDTO(flightEntity.getDepartureCity()) : null;

        CityResponseDTOImpl arrivalCity = flightEntity.getArrivalCity() != null ?
                cityMapper.mapCityEntityToCityResponseDTO(flightEntity.getArrivalCity()) : null;

        PilotResponseDTOImpl captain = flightEntity.getCaptain() != null ?
                pilotMapper.mapPilotEntityToPilotResponseDTO(flightEntity.getCaptain()) : null;

        PilotResponseDTOImpl subCaptain = flightEntity.getSubCaptain() != null ?
                pilotMapper.mapPilotEntityToPilotResponseDTO(flightEntity.getSubCaptain()) : null;
        
        return new FlightResponseDTOImpl(
                idFlight,
                flightNumber,
                idPlane,
                plane,
                idDepartureCity,
                departureCity,
                idArrivalCity,
                arrivalCity,
                departureTime,
                arrivalTime,
                status,
                flightDuration,
                distanceKm,
                seats,
                idCaptain,
                captain,
                idSubCaptain,
                subCaptain,
                priceEconomy,
                priceBusiness,
                priceFirstClass
        );
    }
    public List<FlightResponseDTOImpl> mapFlightEntitiesToFlightResponseDTOs(List<FlightEntityImpl> flightEntities) {
        if (flightEntities == null) {
            return null;
        }
        return flightEntities.stream()
                .map(this::mapFlightEntityToFlightResponseDTO)
                .collect(Collectors.toList());
    }
}

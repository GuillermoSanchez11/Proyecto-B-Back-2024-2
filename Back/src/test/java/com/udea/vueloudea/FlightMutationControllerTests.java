package com.udea.vueloudea;

import com.udea.vueloudea.controller.FlightMutationController;
import com.udea.vueloudea.model.Flight;
import com.udea.vueloudea.model.City;
import com.udea.vueloudea.model.FlightType;
import com.udea.vueloudea.model.AirplaneType;
import com.udea.vueloudea.model.Status;
import com.udea.vueloudea.service.FlightService;
import com.udea.vueloudea.service.CityService;
import com.udea.vueloudea.service.FlightTypeService;
import com.udea.vueloudea.service.AirplaneTypeService;
import com.udea.vueloudea.service.StatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightMutationControllerTests {

    @Mock
    private FlightService flightService;

    @Mock
    private CityService cityService;

    @Mock
    private FlightTypeService flightTypeService;

    @Mock
    private AirplaneTypeService airplaneTypeService;

    @Mock
    private StatusService statusService;

    @InjectMocks
    private FlightMutationController flightMutationController;

    @BeforeEach
    void setUp() {
        // No need to call MockitoAnnotations.openMocks(this) as @ExtendWith(MockitoExtension.class) handles it
    }

    @Test
    void testCreateFlight() {
        Flight flight = new Flight();
        City origin = new City();
        City destination = new City();
        FlightType flightType = new FlightType();
        AirplaneType airplaneType = new AirplaneType();
        Status status = new Status();

        when(cityService.getCityByIataCode("JFK")).thenReturn(origin);
        when(cityService.getCityByIataCode("MDE")).thenReturn(destination);
        when(flightTypeService.getFlightTypeById(1L)).thenReturn(flightType);
        when(airplaneTypeService.getAirplaneTypeById("MAX")).thenReturn(airplaneType);
        when(statusService.getStatusById(1L)).thenReturn(status);
        when(flightService.createFlight(flight)).thenReturn(flight);

        Flight result = flightMutationController.createFlight("MDE504JFK", "JFK", "MDE", 10.0, 100.0, 10.0, 1L, "MAX", "2023-01-01", "2023-01-01", "10:00", "13:00", 1L);
        assertEquals(flight, result);
    }

    @Test
    void testUpdateFlight() {
        Flight flight = new Flight();
        City origin = new City();
        City destination = new City();
        FlightType flightType = new FlightType();
        AirplaneType airplaneType = new AirplaneType();
        Status status = new Status();

        when(flightService.getFlightById(1L)).thenReturn(flight);
        when(cityService.getCityByIataCode("MDE")).thenReturn(origin);
        when(cityService.getCityByIataCode("BOG")).thenReturn(destination);
        when(flightTypeService.getFlightTypeById(1L)).thenReturn(flightType);
        when(airplaneTypeService.getAirplaneTypeById("MAX2")).thenReturn(airplaneType);
        when(statusService.getStatusById(1L)).thenReturn(status);
        when(flightService.updateFlight(flight)).thenReturn(flight);

        Flight result = flightMutationController.updateFlight(1L, "FL123", "MDE", "BOG", 100.0, 10.0, 5.0, 1L, "MAX2", "2023-01-01", "2023-01-01", "10:00", "12:00", 1L);
        assertEquals(flight, result);
    }

    @Test
    void testDeleteFlight() {
        boolean result = flightMutationController.deleteFlight(1L);
        assertTrue(result);
    }
}
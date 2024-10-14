package com.udea.vueloudea;

import com.udea.vueloudea.controller.FlightController;
import com.udea.vueloudea.model.Flight;
import com.udea.vueloudea.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightControllerTests {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    public FlightControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFlights() {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        List<Flight> flights = Arrays.asList(flight1, flight2);

        when(flightService.getAllFlights()).thenReturn(flights);

        List<Flight> result = flightController.getAllFlights();
        assertEquals(2, result.size());
    }

    @Test
    void testGetFlightById() {
        Flight flight = new Flight();
        when(flightService.getFlightById(1L)).thenReturn(flight);

        Flight result = flightController.getFlightById(1L);
        assertEquals(flight, result);
    }
}
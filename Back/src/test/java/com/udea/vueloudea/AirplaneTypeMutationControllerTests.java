package com.udea.vueloudea;

import com.udea.vueloudea.controller.AirplaneTypeMutationController;
import com.udea.vueloudea.model.AirplaneType;
import com.udea.vueloudea.model.Type;
import com.udea.vueloudea.service.AirplaneTypeService;
import com.udea.vueloudea.service.TypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AirplaneTypeMutationControllerTests {

    @Mock
    private AirplaneTypeService airplaneTypeService;

    @Mock
    private TypeService typeService;

    @InjectMocks
    private AirplaneTypeMutationController airplaneTypeMutationController;

    public AirplaneTypeMutationControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAirplaneType() {
        AirplaneType airplaneType = new AirplaneType();
        airplaneType.setId("MAXIMUS");
        airplaneType.setType(new Type());
        airplaneType.setMaxSeats(100);
        airplaneType.setSeatsDistribution("2-2");

        Type type = new Type();
        when(typeService.getTypeById(1L)).thenReturn(type);
        when(airplaneTypeService.createAirplaneType(any(AirplaneType.class))).thenReturn(airplaneType);

        AirplaneType result = airplaneTypeMutationController.createAirplaneType("MAXIMUS", 1L, 100, "2-2");
        assertEquals(airplaneType, result);
    }

    @Test
    void testUpdateAirplaneType() {
        AirplaneType airplaneType = new AirplaneType();
        when(airplaneTypeService.getAirplaneTypeById("1")).thenReturn(airplaneType);
        when(airplaneTypeService.updateAirplaneType(airplaneType)).thenReturn(airplaneType);

        AirplaneType result = airplaneTypeMutationController.updateAirplaneType("1", 1L, 100, "2-2");
        assertEquals(airplaneType, result);
    }

    @Test
    void testDeleteAirplaneType() {
        boolean result = airplaneTypeMutationController.deleteAirplaneType("1");
        assertTrue(result);
    }
}
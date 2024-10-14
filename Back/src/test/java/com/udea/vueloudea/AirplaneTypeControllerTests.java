package com.udea.vueloudea;

import com.udea.vueloudea.controller.AirplaneTypeController;
import com.udea.vueloudea.model.AirplaneType;
import com.udea.vueloudea.service.AirplaneTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirplaneTypeControllerTests {

    @Mock
    private AirplaneTypeService airplaneTypeService;

    @InjectMocks
    private AirplaneTypeController airplaneTypeController;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAirplaneTypeById() {
        AirplaneType airplaneType = new AirplaneType();
        when(airplaneTypeService.getAirplaneTypeById("1")).thenReturn(airplaneType);

        ResponseEntity<AirplaneType> response = restTemplate.getForEntity("/airplaneTypes/1", AirplaneType.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo(airplaneType);
    }

    @Test
    public void testGetAllAirplaneTypes() {
        AirplaneType airplaneType1 = new AirplaneType();
        AirplaneType airplaneType2 = new AirplaneType();
        List<AirplaneType> airplaneTypes = Arrays.asList(airplaneType1, airplaneType2);

        when(airplaneTypeService.getAllAirplaneTypes()).thenReturn(airplaneTypes);

        ResponseEntity<List<AirplaneType>> response = restTemplate.exchange(
                "/airplaneTypes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AirplaneType>>() {}
        );
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo(airplaneTypes);
    }
}
package com.udea.vueloudea;

import com.udea.vueloudea.controller.TypeController;
import com.udea.vueloudea.model.Type;
import com.udea.vueloudea.service.TypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TypeControllerTests {

    @Mock
    private TypeService typeService;

    @InjectMocks
    private TypeController typeController;

    public TypeControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFamilies() {
        Type type1 = new Type();
        type1.setId(1L);
        type1.setName("Type1");

        Type type2 = new Type();
        type2.setId(2L);
        type2.setName("Type2");

        List<Type> types = Arrays.asList(type1, type2);
        when(typeService.getAllTypes()).thenReturn(types);

        List<Type> result = typeController.getAllFamilies();
        assertEquals(types, result);
    }
}
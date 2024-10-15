package com.codefactory.reserva_b.controller;

import com.codefactory.reserva_b.dto.impl.LuggageRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.LuggageResponseDTOImpl;
import com.codefactory.reserva_b.dto.impl.PassengerResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.service.impl.BookingServiceImpl;
import com.codefactory.reserva_b.service.impl.LuggageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LuggageController {
    @Autowired
    private LuggageServiceImpl luggageService;

    @MutationMapping()
    public LuggageResponseDTOImpl addLuggage(@Argument LuggageRequestDTOImpl luggage){
        return luggageService.addLuggage(luggage);
    }

    @MutationMapping()
    public LuggageResponseDTOImpl editLuggage(@Argument String idLuggage, @Argument LuggageRequestDTOImpl luggage){
        return luggageService.editLuggage(idLuggage, luggage);
    }

    @MutationMapping()
    public PassengerResponseDTOImpl deleteLuggage(@Argument String idPassenger, @Argument String idLuggage){
        return luggageService.deleteLuggage(idPassenger, idLuggage);
    }
}

package com.codefactory.reserva_b.service;

import com.codefactory.reserva_b.model.Plane;
import com.codefactory.reserva_b.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository planeRepository;
    public List<Plane> getPlanes() {
        return planeRepository.findAll();
    }
}

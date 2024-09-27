package com.codefactory.reserva_b.repository;

import com.codefactory.reserva_b.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}

package com.codefactory.reserva_b.repository.interfaces;

import com.codefactory.reserva_b.entity.impl.SeatEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ISeatRepository extends JpaRepository<SeatEntityImpl, BigInteger> {
}

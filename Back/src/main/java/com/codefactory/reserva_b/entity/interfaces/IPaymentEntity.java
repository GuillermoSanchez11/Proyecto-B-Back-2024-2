package com.codefactory.reserva_b.entity.interfaces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public interface IPaymentEntity {
    // Getters
    BigInteger getIdPayment();
    BigInteger getIdBooking();
    BigDecimal getAmount();
    LocalDateTime getPaymentDate();
    String getPaymentStatus();

    // Setters
    void setIdPayment(BigInteger idPayment);
    void setIdBooking(BigInteger idBooking);
    void setAmount(BigDecimal amount);
    void setPaymentDate(LocalDateTime paymentDate);
    void setPaymentStatus(String paymentStatus);
}

package com.codefactory.reserva_b.dto.interfaces;

import java.time.LocalDateTime;

public interface IPaymentResponseDTO {
    Long getIdPayment();
    Long getIdBooking();
    Float getAmount();
    LocalDateTime getPaymentDate();
    String getPaymentStatus();
}

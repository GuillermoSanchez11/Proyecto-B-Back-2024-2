package com.codefactory.reserva_b.dto.impl;

import com.codefactory.reserva_b.dto.interfaces.IPaymentResponseDTO;

import java.time.LocalDateTime;

public class PaymentResponseDTOImpl implements IPaymentResponseDTO {
    private final Long idPayment;
    private final Long idBooking;
    private final Float amount;
    private final LocalDateTime paymentDate;
    private final String paymentStatus;

    public PaymentResponseDTOImpl(Long idPayment, Long idBooking, Float amount, LocalDateTime paymentDate, String paymentStatus) {
        this.idPayment = idPayment;
        this.idBooking = idBooking;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public Long getIdPayment() {
        return idPayment;
    }

    @Override
    public Long getIdBooking() {
        return idBooking;
    }

    @Override
    public Float getAmount() {
        return amount;
    }

    @Override
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String getPaymentStatus() {
        return paymentStatus;
    }
}

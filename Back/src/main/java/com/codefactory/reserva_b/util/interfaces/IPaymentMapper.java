package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.PaymentResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPaymentResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPaymentEntity;

public interface IPaymentMapper {
    PaymentResponseDTOImpl mapPaymentEntityToPaymentResponseDTO(IPaymentEntity paymentEntity);
}

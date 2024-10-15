package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.PaymentResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPaymentResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPaymentEntity;
import com.codefactory.reserva_b.util.interfaces.IPaymentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentMapperImpl implements IPaymentMapper {
    @Override
    public PaymentResponseDTOImpl mapPaymentEntityToPaymentResponseDTO(IPaymentEntity paymentEntity) {
        if (paymentEntity == null) {
            return null;
        }
        Long idPayment = paymentEntity.getIdPayment().longValue();
        Long idBooking = paymentEntity.getIdBooking().longValue();
        Float amount = paymentEntity.getAmount() != null ? paymentEntity.getAmount().floatValue() : null;
        LocalDateTime paymentDate = paymentEntity.getPaymentDate();
        String paymentStatus = paymentEntity.getPaymentStatus();

        return new PaymentResponseDTOImpl(
                idPayment,
                idBooking,
                amount,
                paymentDate,
                paymentStatus
        );
    }
}

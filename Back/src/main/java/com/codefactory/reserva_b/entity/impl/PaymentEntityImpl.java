package com.codefactory.reserva_b.entity.impl;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import com.codefactory.reserva_b.entity.interfaces.IPaymentEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class PaymentEntityImpl implements IPaymentEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private BigInteger idPayment;

    @Column(name = "id_booking", nullable = false)
    private BigInteger idBooking;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    // Constructor
    public PaymentEntityImpl(BigInteger idBooking, BigDecimal amount, LocalDateTime paymentDate, String paymentStatus) {
        this.idBooking = idBooking;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public PaymentEntityImpl() {
    }

    public BigInteger getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(BigInteger idPayment) {
        this.idPayment = idPayment;
    }

    public BigInteger getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(BigInteger idBooking) {
        this.idBooking = idBooking;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntityImpl that = (PaymentEntityImpl) o;
        return Objects.equals(idPayment, that.idPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPayment);
    }

    @Override
    public String toString() {
        return "PaymentEntityImpl{" +
                "idPayment=" + idPayment +
                ", idBooking=" + idBooking +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

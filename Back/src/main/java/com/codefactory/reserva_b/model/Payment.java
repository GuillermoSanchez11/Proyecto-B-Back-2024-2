package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private BigInteger idPayment;

    @Column(name = "id_booking", nullable = false)
    private BigInteger booking;  // Relación con Booking

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    // Constructor
    public Payment(BigInteger idPayment, BigInteger booking, BigDecimal amount, LocalDateTime paymentDate,
                   String paymentStatus) {
        this.idPayment = idPayment;
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public Payment() {

    }
    // Getters y Setters

    public BigInteger getId() {
        return idPayment;
    }

    public void setId(BigInteger idPayment) {
        this.idPayment = idPayment;
    }

    public BigInteger getBooking() {
        return booking;
    }

    public void setBooking(BigInteger booking) {
        this.booking = booking;
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

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(idPayment, payment.idPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment);
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + idPayment +
                ", booking=" + booking +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

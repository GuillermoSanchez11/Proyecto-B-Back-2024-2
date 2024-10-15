package com.codefactory.reserva_b.entity.impl;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import com.codefactory.reserva_b.entity.interfaces.IPassengerEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "passenger")
public class PassengerEntityImpl implements IPassengerEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passenger")
    private BigInteger idPassenger;

    @Column(name = "id_seat", nullable = false)
    private BigInteger idSeat;

    @ManyToOne
    @JoinColumn(name = "id_seat", nullable = false, insertable=false, updatable=false)
    private SeatEntityImpl seat;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "special_requests")
    private String specialRequests;

    @Column(name = "luggage_included", nullable = false)
    private Boolean luggageIncluded;

    @OneToMany(mappedBy = "idPassenger", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LuggageEntityImpl> luggage;

    // Constructor
    public PassengerEntityImpl(BigInteger idSeat, String firstName, String lastName, LocalDate dateOfBirth,
                               String documentId, String passportNumber, String nationality, String specialRequests,
                               Boolean luggageIncluded) {
        this.idSeat = idSeat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.documentId = documentId;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.specialRequests = specialRequests;
        this.luggageIncluded = luggageIncluded;
    }

    public PassengerEntityImpl() {
    }

    public BigInteger getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(BigInteger idPassenger) {
        this.idPassenger = idPassenger;
    }

    public BigInteger getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(BigInteger idSeat) {
        this.idSeat = idSeat;
    }

    public SeatEntityImpl getSeat() {
        return seat;
    }

    public void setSeat(SeatEntityImpl seat) {
        this.seat = seat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public Boolean getLuggageIncluded() {
        return luggageIncluded;
    }

    public void setLuggageIncluded(Boolean luggageIncluded) {
        this.luggageIncluded = luggageIncluded;
    }

    public List<LuggageEntityImpl> getLuggage() {
        return luggage;
    }

    public void setLuggage(List<LuggageEntityImpl> luggage) {
        this.luggage = luggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerEntityImpl that = (PassengerEntityImpl) o;
        return Objects.equals(idPassenger, that.idPassenger);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPassenger);
    }

    @Override
    public String toString() {
        return "PassengerEntityImpl{" +
                "idPassenger=" + idPassenger +
                ", idSeat=" + idSeat +
                ", seat=" + seat +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", documentId='" + documentId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", specialRequests='" + specialRequests + '\'' +
                ", luggageIncluded=" + luggageIncluded +
                ", luggage=" + luggage +
                '}';
    }
}

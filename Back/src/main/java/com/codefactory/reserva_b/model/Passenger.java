package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passenger")
    private Long idPassenger;

    @Column(name = "id_seat", nullable = false)
    private Long idSeat;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "special_requests", nullable = false)
    private String specialRequests;

    @Column(name = "luggage_included", nullable = false)
    private Boolean luggageIncluded;

    // Constructor
    public Passenger(Long idPassenger, Long idSeat, String firstName, String lastName, LocalDate dateOfBirth,
                     String documentId, String passportNumber, String nationality, String specialRequests,
                     Boolean luggageIncluded) {
        this.idPassenger = idPassenger;
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

    public Passenger() {

    }

    // Getters y Setters

    public Long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Long idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Long idSeat) {
        this.idSeat = idSeat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return Objects.equals(idPassenger, passenger.idPassenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassenger);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "idPassenger=" + idPassenger +
                ", idSeat=" + idSeat +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", documentId='" + documentId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", specialRequests='" + specialRequests + '\'' +
                ", luggageIncluded=" + luggageIncluded +
                '}';
    }
}

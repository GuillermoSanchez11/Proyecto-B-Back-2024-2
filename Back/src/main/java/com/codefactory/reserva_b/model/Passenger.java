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
    private Long seat;  // Relación con Seat

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    // Constructor por defecto
    public Passenger() {
    }

    // Constructor con todos los campos
    public Passenger(Long idPassenger, Long seat, String name, String lastname, LocalDate birthday, String documentId, String passportNumber) {
        this.idPassenger = idPassenger;
        this.seat = seat;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.documentId = documentId;
        this.passportNumber = passportNumber;
    }

    // Getters y Setters
    public Long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Long idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Long getSeat() {
        return seat;
    }

    public void setSeat(Long seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
                ", seat=" + seat +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", documentId='" + documentId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}

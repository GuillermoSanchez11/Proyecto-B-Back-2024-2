package com.codefactory.reserva_b.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long idUser;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "genrer", nullable = false)
    private String genrer;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    // Constructor por defecto
    public Users() {
    }

    // Constructor con todos los campos
    public Users(Long idUser, String name, String lastname, String email, String genrer, LocalDate birthday, String country, String city, String documentId, String passportNumber, LocalDate registerDate) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.genrer = genrer;
        this.birthday = birthday;
        this.country = country;
        this.city = city;
        this.documentId = documentId;
        this.passportNumber = passportNumber;
        this.registerDate = registerDate;
    }

    // Getters y Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenrer() {
        return genrer;
    }

    public void setGenrer(String genrer) {
        this.genrer = genrer;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users user)) return false;
        return Objects.equals(idUser, user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", genrer='" + genrer + '\'' +
                ", birthday=" + birthday +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", documentId='" + documentId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}

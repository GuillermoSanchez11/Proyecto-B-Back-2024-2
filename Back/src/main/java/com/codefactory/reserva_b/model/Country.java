package com.codefactory.reserva_b.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Long idCountry;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = false)
    private String continent;

    @Column(name = "language", nullable = false)
    private String language;

    // Constructor
    public Country(Long idCountry, String name, String continent, String language) {
        this.idCountry = idCountry;
        this.name = name;
        this.continent = continent;
        this.language = language;
    }

    public Country() {

    }

    // Getters y Setters


    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country plane)) return false;
        return Objects.equals(idCountry, plane.idCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry);
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
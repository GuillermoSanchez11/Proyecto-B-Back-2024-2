package com.codefactory.reserva_b.entity.impl;

import com.codefactory.reserva_b.entity.interfaces.ICountryEntity;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "country")
public class CountryEntityImpl implements ICountryEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private BigInteger idCountry;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = false)
    private String continent;

    @Column(name = "language", nullable = false)
    private String language;

    // Constructor
    public CountryEntityImpl(String name, String continent, String language) {
        this.name = name;
        this.continent = continent;
        this.language = language;
    }

    public CountryEntityImpl() {
    }

    public BigInteger getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(BigInteger idCountry) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntityImpl that = (CountryEntityImpl) o;
        return Objects.equals(idCountry, that.idCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCountry);
    }

    @Override
    public String toString() {
        return "CountryEntityImpl{" +
                "idCountry=" + idCountry +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
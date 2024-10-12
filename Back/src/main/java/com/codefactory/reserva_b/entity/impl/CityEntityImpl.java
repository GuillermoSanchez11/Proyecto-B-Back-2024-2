package com.codefactory.reserva_b.entity.impl;

import com.codefactory.reserva_b.entity.interfaces.ICityEntity;
import com.codefactory.reserva_b.entity.interfaces.IEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "city")
public class CityEntityImpl implements ICityEntity, IEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private BigInteger idCity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country_id", nullable = false)
    private BigInteger countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable=false, updatable=false)
    private CountryEntityImpl country;

    @Column(name = "timezone", nullable = false)
    private String timezone;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    // Constructor
    public CityEntityImpl(String name, BigInteger countryId, String timezone, Double latitude, Double longitude) {
        this.name = name;
        this.countryId = countryId;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CityEntityImpl() {
    }

    public BigInteger getIdCity() {
        return idCity;
    }

    public void setIdCity(BigInteger idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCountryId() {
        return countryId;
    }

    public void setCountryId(BigInteger countryId) {
        this.countryId = countryId;
    }

    public CountryEntityImpl getCountry() {
        return country;
    }

    public void setCountry(CountryEntityImpl country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntityImpl that = (CityEntityImpl) o;
        return Objects.equals(idCity, that.idCity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCity);
    }

    @Override
    public String toString() {
        return "CityEntityImpl{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                ", country=" + country +
                ", timezone='" + timezone + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
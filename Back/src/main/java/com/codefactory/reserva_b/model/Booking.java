package com.codefactory.reserva_b.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Long idBooking;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false)
    private Flight flight;  // Relación con Passenger

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDate created;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updated;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "users_booking", joinColumns = @JoinColumn(name = "id_booking"), inverseJoinColumns = @JoinColumn(name = "id_users"))
    private Set<Users> app_users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "booking_passenger", joinColumns = @JoinColumn(name = "id_booking"), inverseJoinColumns = @JoinColumn(name = "id_passenger"))
    private Set<Passenger> passengers;

    // Constructor por defecto
    public Booking() {
    }

    // Constructor con todos los campos
    public Booking(Long idBooking, Flight flight, LocalDate created, LocalDate updated, String status) {
        this.idBooking = idBooking;
        this.flight = flight;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    // Getters y Setters
    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Set<Users> getUsers() {
        return app_users;
    }

    public void setUsers(Set<Users> users) {
        this.app_users = users;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(idBooking, booking.idBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", flight=" + flight +
                ", created=" + created +
                ", updated=" + updated +
                ", status='" + status + '\'' +
                '}';
    }
}

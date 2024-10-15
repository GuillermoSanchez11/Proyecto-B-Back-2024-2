package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.util.interfaces.ISqlSentences;

public class SqlSentencesImpl implements ISqlSentences {
    private static final String FIND_ALL_BOOKINGS = "SELECT * FROM booking";
    private static final String FIND_BOOKINGS_BY_ID_USER = "SELECT * FROM booking WHERE id_user = ?";
    private static final String FIND_BOOKING_BY_ID_BOOKING = "SELECT * FROM booking WHERE id_booking = ?";
    private static final String INSERT_BOOKING = "INSERT INTO booking (id_flight, id_user, booking_date, booking_status) VALUES (?, ?, ?, ?) RETURNING id_booking";
    private static final String INSERT_PASSENGER = "INSERT INTO passenger (id_seat, first_name, last_name, date_of_birth, document_id, passport_number, nationality, special_requests, luggage_included) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_passenger";
    private static final String INSERT_BOOKING_PASSENGER = "INSERT INTO booking_passenger (id_booking, id_passenger) VALUES (?, ?)";
    private static final String UPDATE_IS_RESERVED = "UPDATE seat SET is_reserved = ? WHERE id_seat = ?";
    private static final String INSERT_LUGGAGE = "INSERT INTO luggage (id_passenger, type, height_cm, weight_kg, width_cm, extra_free) VALUES (?, ?, ?, ?, ?, ?) RETURNING *";
    private static final String FIND_ID_PASSENGERS_BY_ID_BOOKING = "SELECT id_passenger FROM booking_passenger WHERE id_booking = ?";
    private static final String FIND_ID_SEAT_BY_ID_PASSENGER = "SELECT id_seat FROM passenger WHERE id_passenger = ?";
    private static final String DELETE_LUGGAGE = "DELETE FROM luggage WHERE id_passenger = ?";
    private static final String DELETE_PASSENGER = "DELETE FROM passenger WHERE id_passenger = ?";
    private static final String DELETE_BOOKING_PASSENGER = "DELETE FROM booking_passenger WHERE id_booking = ? AND id_passenger = ?";
    private static final String DELETE_BOOKING = "DELETE FROM booking WHERE id_booking = ?";
    private static final String UPDATE_BOOKING_STATUS = "UPDATE booking SET booking_status = ? WHERE id_booking = ?";
    private static final String FIND_ALL_FLIGHTS = "SELECT * FROM flight";
    private static final String FIND_PASSENGER_BY_ID_PASSENGER = "SELECT * FROM passenger WHERE id_passenger = ?";
    private static final String UPDATE_LUGGAGE_INCLUDED = "UPDATE passenger SET luggage_included = ? WHERE id_passenger = ?";
    private static final String UPDATE_LUGGAGE_INFO = "UPDATE luggage SET type = ?, height_cm = ?, weight_kg = ?, width_cm = ?, extra_free = ? WHERE id_luggage = ? RETURNING *";
    private static final String COUNT_LUGGAGE_BY_ID_PASSENGER = "SELECT COUNT(*) FROM luggage WHERE id_passenger = ?";
    private static final String FIND_AVAILABLE_SEATS = "SELECT * FROM seat WHERE id_flight = ? AND is_reserved = false";
    private static final String FIND_PASSENGERS_BY_ID_BOOKING = "SELECT id_passenger FROM booking_passenger WHERE id_booking = ?";
    private static final String UPDATE_ID_SEAT = "UPDATE passenger SET id_seat = ? WHERE id_passenger = ?";
    private static final String UPDATE_PASSENGER_INFO = "UPDATE passenger SET first_name = ?, last_name = ?, date_of_birth = ?, document_id = ?, passport_number = ?, nationality = ?, special_requests = ? WHERE id_passenger = ?";

    @Override
    public String selectAllBookingsSentence() {
        return FIND_ALL_BOOKINGS;
    }

    @Override
    public String selectBookingByIdUserSentence() {
        return FIND_BOOKINGS_BY_ID_USER;
    }

    @Override
    public String selectBookingByIdBookingSentence() {
        return FIND_BOOKING_BY_ID_BOOKING;
    }

    @Override
    public String insertBookingSentence() {
        return INSERT_BOOKING;
    }

    @Override
    public String insertPassengerSentence() {
        return INSERT_PASSENGER;
    }

    @Override
    public String insertBookingPassengerSentence() {
        return INSERT_BOOKING_PASSENGER;
    }

    @Override
    public String updateIsReservedSentence() {
        return UPDATE_IS_RESERVED;
    }

    @Override
    public String insertLuggageSentence() {
        return INSERT_LUGGAGE;
    }

    @Override
    public String selectIdPassengersByIdBookingSentence() {
        return FIND_ID_PASSENGERS_BY_ID_BOOKING;
    }

    @Override
    public String selectIdSeatFromIdPassenger() {
        return FIND_ID_SEAT_BY_ID_PASSENGER;
    }

    @Override
    public String deleteLuggageSentence() {
        return DELETE_LUGGAGE;
    }

    @Override
    public String deletePassengerSentence() {
        return DELETE_PASSENGER;
    }

    @Override
    public String deleteBookingPassengerSentence() {
        return DELETE_BOOKING_PASSENGER;
    }

    @Override
    public String deleteBookingSentence() {
        return DELETE_BOOKING;
    }

    @Override
    public String updateBookingStatusSentence() {
        return UPDATE_BOOKING_STATUS;
    }

    @Override
    public String selectAllFlightsSentence() {
        return FIND_ALL_FLIGHTS;
    }

    @Override
    public String selectPassengerByIdPassengerSentence() {
        return FIND_PASSENGER_BY_ID_PASSENGER;
    }

    @Override
    public String updateLuggageIncludedSentence() {
        return UPDATE_LUGGAGE_INCLUDED;
    }

    @Override
    public String updateLuggageInfoSentence() {
        return UPDATE_LUGGAGE_INFO;
    }

    @Override
    public String selectLuggageCountByIdPassengerSentence() {
        return COUNT_LUGGAGE_BY_ID_PASSENGER;
    }

    @Override
    public String selectAllSeatsSentence() {
        return FIND_AVAILABLE_SEATS;
    }

    @Override
    public String selectPassengerByIdBookingSentence() {
        return FIND_PASSENGERS_BY_ID_BOOKING;
    }

    @Override
    public String updatePassengerIdSeatSentence() {
        return UPDATE_ID_SEAT;
    }

    @Override
    public String updatePassengerInfoSentence() {
        return UPDATE_PASSENGER_INFO;
    }
}

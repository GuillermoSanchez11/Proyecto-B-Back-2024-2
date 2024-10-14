package com.codefactory.reserva_b.util.interfaces;

public interface ISqlSentences {
    String selectAllBookingsSentence();
    String selectBookingByIdUserSentence();
    String selectBookingByIdBookingSentence();
    String insertBookingSentence();
    String insertPassengerSentence();
    String insertBookingPassengerSentence();
    String updateIsReservedSentence();
    String insertLuggageSentence();
    String selectIdPassengersByIdBookingSentence();
    String selectIdSeatFromIdPassenger();
    String deleteLuggageSentence();
    String deletePassengerSentence();
    String deleteBookingPassengerSentence();
    String deleteBookingSentence();
    String updateBookingStatusSentence();
    String selectAllFlightsSentence();
    String selectPassengerByIdPassengerSentence();
    String updateLuggageIncludedSentence();
    String updateLuggageInfoSentence();
    String selectLuggageCountByIdPassengerSentence();
    String selectAllSeatsSentence();
    String selectPassengerByIdBookingSentence();
    String updatePassengerIdSeatSentence();
    String updatePassengerInfoSentence();
}

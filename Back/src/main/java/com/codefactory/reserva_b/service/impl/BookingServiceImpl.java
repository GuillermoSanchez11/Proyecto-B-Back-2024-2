package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.service.interfaces.IBookingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {
    @Autowired
    private IBookingRepository bookingRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<BookingEntityImpl> findAllBookings() {
        return bookingRepository.findAllBookings();
    }

    public List<BookingEntityImpl> findBookingsByIdUser(String idUser) {
        return bookingRepository.findBookingsByIdUser(new BigInteger(idUser));
    }

    public BookingEntityImpl findBookingByIdBooking(String idBooking) {
        return bookingRepository.findBookingByIdBooking(new BigInteger(idBooking));
    }

    @Transactional
    public BookingEntityImpl addBooking(BookingEntityImpl booking) {
        return bookingRepository.createBooking(booking);
    }

    @Transactional
    public List<BookingEntityImpl> deleteBooking(String idBooking) {
        return bookingRepository.deleteBooking(idBooking);
    }

    @Transactional
    public BookingEntityImpl editBookingStatus(String bookingStatus, String idBooking) {
        return bookingRepository.editBookingStatus(bookingStatus, idBooking);
    }
}

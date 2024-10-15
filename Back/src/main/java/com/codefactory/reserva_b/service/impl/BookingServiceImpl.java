package com.codefactory.reserva_b.service.impl;

import com.codefactory.reserva_b.dto.impl.BookingRequestDTOImpl;
import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.repository.interfaces.IBookingRepository;
import com.codefactory.reserva_b.service.interfaces.IBookingService;
import com.codefactory.reserva_b.util.interfaces.IBookingMapper;
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
    @Autowired
    private IBookingMapper bookingMapper;

    @Override
    public List<BookingResponseDTOImpl> findAllBookings() {
        List<BookingEntityImpl> bookings = bookingRepository.findAllBookings();
        return bookingMapper.mapBookingEntitiesToBookingResponseDTOs(bookings);
    }

    @Override
    public List<BookingResponseDTOImpl> findBookingsByIdUser(String idUser) {
        List<BookingEntityImpl> bookings = bookingRepository.findBookingsByIdUser(new BigInteger(idUser));
        return bookingMapper.mapBookingEntitiesToBookingResponseDTOs(bookings);
    }

    @Override
    public BookingResponseDTOImpl findBookingByIdBooking(String idBooking) {
        BookingEntityImpl booking = bookingRepository.findBookingByIdBooking(new BigInteger(idBooking));
        return bookingMapper.mapBookingEntityToBookingResponseDTO(booking);
    }

    @Override
    public BookingResponseDTOImpl addBooking(BookingRequestDTOImpl booking) {
        BookingEntityImpl newBooking = bookingRepository.createBooking(booking);
        return bookingMapper.mapBookingEntityToBookingResponseDTO(newBooking);
    }

    @Override
    public List<BookingResponseDTOImpl> deleteBooking(String idBooking) {
        List<BookingEntityImpl> bookings = bookingRepository.deleteBooking(new BigInteger(idBooking));
        return bookingMapper.mapBookingEntitiesToBookingResponseDTOs(bookings);
    }

    @Override
    public BookingResponseDTOImpl editBookingStatus(String bookingStatus, String idBooking) {
        BookingEntityImpl booking = bookingRepository.editBookingStatus(bookingStatus, new BigInteger(idBooking));
        return bookingMapper.mapBookingEntityToBookingResponseDTO(booking);
    }
}

package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.*;
import com.codefactory.reserva_b.dto.interfaces.*;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.impl.PassengerEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.IBookingEntity;
import com.codefactory.reserva_b.util.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapperImpl implements IBookingMapper {
    @Autowired
    private IFlightMapper flightMapper;
    @Autowired
    private IUsersMapper usersMapper;
    @Autowired
    private IPassengerMapper passengerMapper;
    @Autowired
    private IPaymentMapper paymentMapper;
    @Override
    public BookingResponseDTOImpl mapBookingEntityToBookingResponseDTO(IBookingEntity bookingEntity) {
        if (bookingEntity == null) {
            return null;
        }
        Long idBooking = bookingEntity.getIdBooking().longValue();
        Long idFlight = bookingEntity.getIdFlight().longValue();
        Long idUser = bookingEntity.getIdUser().longValue();
        LocalDateTime bookingDate = bookingEntity.getBookingDate();
        String bookingStatus = bookingEntity.getBookingStatus();
        FlightResponseDTOImpl flight = bookingEntity.getFlight() != null ?
                flightMapper.mapFlightEntityToFlightResponseDTO(bookingEntity.getFlight()) : null;

        UsersResponseDTOImpl user = bookingEntity.getUser() != null ?
                usersMapper.mapUsersEntityToUsersResponseDTO(bookingEntity.getUser()) : null;

        List<PassengerResponseDTOImpl> passengers = bookingEntity.getPassengers() != null ?
                passengerMapper.mapPassengerEntitiesToPassengerResponseDTOs(bookingEntity.getPassengers()) : null;

        PaymentResponseDTOImpl payment = bookingEntity.getPayment() != null ?
                paymentMapper.mapPaymentEntityToPaymentResponseDTO(bookingEntity.getPayment()) : null;

        return new BookingResponseDTOImpl(
                idBooking,
                idFlight,
                flight,
                idUser,
                user,
                bookingDate,
                bookingStatus,
                passengers,
                payment
        );
    }
    public List<BookingResponseDTOImpl> mapBookingEntitiesToBookingResponseDTOs(List<BookingEntityImpl> bookingEntities) {
        if (bookingEntities == null) {
            return null;
        }
        return bookingEntities.stream()
                .map(this::mapBookingEntityToBookingResponseDTO)
                .collect(Collectors.toList());
    }
}

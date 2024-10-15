package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.BookingResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IBookingResponseDTO;
import com.codefactory.reserva_b.entity.impl.BookingEntityImpl;
import com.codefactory.reserva_b.entity.interfaces.IBookingEntity;

import java.util.List;

public interface IBookingMapper {
    BookingResponseDTOImpl mapBookingEntityToBookingResponseDTO(IBookingEntity bookingEntity);
    List<BookingResponseDTOImpl> mapBookingEntitiesToBookingResponseDTOs(List<BookingEntityImpl> bookingEntities);
}

package ru.practicum.shareit.booking;

import ru.practicum.shareit.booking.dto.CreateBookingDto;
import ru.practicum.shareit.booking.dto.GetBookingDto;
import ru.practicum.shareit.booking.model.State;

import java.util.List;

public interface BookingService {

    List<GetBookingDto> getUserBookings(long userId, State state, int from, int size);

    List<GetBookingDto> getOwnerBookings(long userId, State state, int from, int size);

    GetBookingDto getBookingByUserOwner(long userId, long bookingId);

    GetBookingDto create(long userid, CreateBookingDto createBookingDto);

    GetBookingDto approveBooking(long userId, long bookingId, Boolean approved);
}
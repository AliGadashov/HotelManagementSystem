package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateBookingRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.BookingResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Booking;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {GuestMapper.class, RoomMapper.class, PaymentMapper.class})
public interface BookingMapper {


    @Named("toBookingResponse")
    @Mappings({
            @Mapping(target = "guest", qualifiedByName = "toGuestResponse"),
            @Mapping(target = "room", qualifiedByName = "toRoomResponse"),
            @Mapping(target = "payments", qualifiedByName = "toPaymentResponse")
    })
    BookingResponse toBookingResponse (Booking booking);
    Booking toBooking (CreateBookingRequest request);
    Booking updateBooking (@MappingTarget Booking booking, UpdateBookingRequest request);

}

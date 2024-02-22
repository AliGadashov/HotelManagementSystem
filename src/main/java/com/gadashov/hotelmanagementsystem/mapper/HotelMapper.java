package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.HotelResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {StaffMapper.class, RoomMapper.class, GuestMapper.class})
public interface HotelMapper {

    @Named("toHotelResponse")
    @Mappings({
            @Mapping(target = "staffs",qualifiedByName = "toStaffResponse"),
            @Mapping(target = "rooms", qualifiedByName = "toRoomResponse"),
            @Mapping(target = "guests", qualifiedByName = "toGuestResponse")
    })
    HotelResponse toHotelResponse (Hotel hotel);
    Hotel toHotel (CreateHotelRequest request);
    Hotel updateHotel (@MappingTarget Hotel hotel, UpdateHotelRequest request);
}

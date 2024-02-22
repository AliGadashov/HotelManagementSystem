package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomTypeRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomTypeResponse;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RoomTypeMapper {


    @Named("toRoomTypeResponse")
    RoomTypeResponse toRoomTypeResponse (RoomType roomType);
    RoomType toRoomType (CreateRoomTypeRequest request);
    RoomType updateRoomType (@MappingTarget RoomType roomType, UpdateRoomTypeRequest request);
}

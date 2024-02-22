package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateRoomRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.RoomResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Room;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {RoomTypeMapper.class})
public interface RoomMapper {

    @Named("toRoomResponse")
    @Mapping(target = "roomType", qualifiedByName = "toRoomTypeResponse")
    RoomResponse toRoomResponse (Room room);
    Room toRoom (CreateRoomRequest request);
    Room updateRoom (@MappingTarget Room room, UpdateRoomRequest request);
    
}

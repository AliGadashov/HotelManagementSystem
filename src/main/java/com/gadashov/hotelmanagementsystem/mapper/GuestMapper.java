package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)


    public interface GuestMapper {

    @Named("toGuestResponse")
    GuestResponse toGuestResponse (Guest guest);
    Guest toGuest (CreateGuestRequest request);
    Guest updateGuest (@MappingTarget Guest guest, UpdateGuestRequest request);

}

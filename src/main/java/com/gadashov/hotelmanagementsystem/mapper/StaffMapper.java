package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.StaffResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Staff;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StaffMapper {

    @Named("toStaffResponse")
    StaffResponse toStaffResponse (Staff staff);
    Staff toStaff (CreateStaffRequest request);
    Staff updateStaff (@MappingTarget Staff staff, UpdateStaffRequest request);

}

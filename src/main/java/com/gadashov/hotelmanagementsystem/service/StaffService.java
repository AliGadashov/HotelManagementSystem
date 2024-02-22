package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.StaffResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Staff;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface StaffService {
    void createStaff(CreateStaffRequest request);
    void updateStaffById(Long id, UpdateStaffRequest request);

    StaffResponse getStaffById(Long id);

    List<StaffResponse> getAllStaff();

    void deleteStaff(Long id);

    List<StaffResponse> getAllStaffByHotel(Long hotelId);

    Staff findStaffById(Long id);
}

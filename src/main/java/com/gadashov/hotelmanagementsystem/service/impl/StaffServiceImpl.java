package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.StaffMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateStaffRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.StaffResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.entity.Staff;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.StaffException;
import com.gadashov.hotelmanagementsystem.repository.StaffRepository;
import com.gadashov.hotelmanagementsystem.service.HotelService;
import com.gadashov.hotelmanagementsystem.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final HotelService hotelService;
    @Override
    public void createStaff(CreateStaffRequest request) {
        Hotel hotel = hotelService.findHotelById(request.hotelId());
        Staff staff = staffMapper.toStaff(request);
        staff.setHotel(hotel);
        staffRepository.save(staff);
    }

    @Override
    public void updateStaffById(Long id, UpdateStaffRequest request) {
        Staff staff = findStaffById(id);
        Staff updatedStaff = staffMapper.updateStaff(staff, request);
        staffRepository.save(updatedStaff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.delete(findStaffById(id));
    }

    @Override
    public StaffResponse getStaffById(Long id) {
        return staffMapper.toStaffResponse(findStaffById(id));
    }

    @Override
    public List<StaffResponse> getAllStaff() {
        List<Staff> staffs = staffRepository.findAll();
        return staffs.stream()
                .map(staffMapper::toStaffResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffResponse> getAllStaffByHotel(Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);

        List<Staff> staffs = hotel.getStaffs();

        return staffs.stream()
                .map(staffMapper::toStaffResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Staff findStaffById(Long id){

        return staffRepository.findById(id)
                .orElseThrow(() -> new StaffException(Exceptions.STAFF_NOT_FOUND));
    }
}

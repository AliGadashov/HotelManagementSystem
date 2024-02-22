package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface GuestService {


    void createGuest(CreateGuestRequest request);

    void updateGuestById(Long id, UpdateGuestRequest request);

    GuestResponse getGuestById(Long id);

    List<GuestResponse> getAllGuest();

    void deleteGuest(Long id);

    Guest findGuestById(Long id);

    List<GuestResponse> getAllGuestByHotel(Long hotelId);

    GuestResponse getAllGuestByEmail(String email);
}

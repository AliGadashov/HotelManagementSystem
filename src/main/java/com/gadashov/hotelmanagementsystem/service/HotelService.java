package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.HotelResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface HotelService {
    void createHotel(CreateHotelRequest request);
    void updateHotelById(Long id, UpdateHotelRequest request);
    HotelResponse getHotelById(Long id);
    List<HotelResponse> getAllHotel();
    void deleteHotel(Long id);
    List<HotelResponse> getAllHotelByStar(int star);
    Hotel findHotelById(Long id);
}

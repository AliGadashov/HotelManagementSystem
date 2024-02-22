package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.HotelMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateHotelRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.HotelResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.HotelException;
import com.gadashov.hotelmanagementsystem.repository.HotelRepository;
import com.gadashov.hotelmanagementsystem.service.HotelService;
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
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    @Override
    public void createHotel(CreateHotelRequest request) {
        Hotel hotel = hotelMapper.toHotel(request);
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotelById(Long id, UpdateHotelRequest request) {
        Hotel hotel = findHotelById(id);
        Hotel updatedHotel = hotelMapper.updateHotel(hotel, request);
        hotelRepository.save(updatedHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.delete(findHotelById(id));
    }

    @Override
    public HotelResponse getHotelById(Long id) {
        return hotelMapper.toHotelResponse(findHotelById(id));
    }

    @Override
    public List<HotelResponse> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotelMapper::toHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelResponse> getAllHotelByStar(int star) {
        List<Hotel> hotelByStars = hotelRepository.getHotelByStars(star);
        return hotelByStars.stream()
                .map(hotelMapper::toHotelResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Hotel findHotelById(Long id){

        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelException(Exceptions.HOTEL_NOT_FOUND));
    }
}

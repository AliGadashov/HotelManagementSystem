package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.GuestMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.GuestException;
import com.gadashov.hotelmanagementsystem.repository.GuestRepository;
import com.gadashov.hotelmanagementsystem.service.GuestService;
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
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final HotelService hotelService;
    private final GuestMapper guestMapper;
    @Override
    public void createGuest(CreateGuestRequest request) {
        Guest guest = guestMapper.toGuest(request);
        guestRepository.save(guest);
    }

    @Override
    public void updateGuestById(Long id, UpdateGuestRequest request) {
        Guest guest = findGuestById(id);
        Guest updatedGuest = guestMapper.updateGuest(guest, request);
        guestRepository.save(updatedGuest);
    }

    @Override
    public GuestResponse getGuestById(Long id) {
        return guestMapper.toGuestResponse(findGuestById(id));
    }

    @Override
    public List<GuestResponse> getAllGuest() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guestMapper::toGuestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGuest(Long id) {
        guestRepository.delete(findGuestById(id));
    }


    @Override
    public List<GuestResponse> getAllGuestByHotel(Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        List<Guest> guest = hotel.getGuests();

        return guest.stream()
                .map(guestMapper::toGuestResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GuestResponse getAllGuestByEmail(String email) {
        Guest guest = guestRepository.getGuestByEmail(email);
        return guestMapper.toGuestResponse(guest);
    }

    @Override
    public Guest findGuestById(Long id){

        return guestRepository.findById(id)
                .orElseThrow(() -> new GuestException(Exceptions.GUEST_NOT_FOUND));
    }
}

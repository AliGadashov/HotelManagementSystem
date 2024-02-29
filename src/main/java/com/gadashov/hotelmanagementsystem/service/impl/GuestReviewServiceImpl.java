package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.GuestReviewMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestReviewResponse;
import com.gadashov.hotelmanagementsystem.model.entity.GuestReview;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.entity.Room;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.enums.ReviewType;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import com.gadashov.hotelmanagementsystem.model.exceptions.GuestReviewException;
import com.gadashov.hotelmanagementsystem.repository.GuestReviewRepository;
import com.gadashov.hotelmanagementsystem.repository.HotelRepository;
import com.gadashov.hotelmanagementsystem.repository.RoomRepository;
import com.gadashov.hotelmanagementsystem.service.GuestReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:20 AM
 */
@Service
@RequiredArgsConstructor
public class GuestReviewServiceImpl implements GuestReviewService {

    private final GuestReviewRepository guestReviewRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final GuestReviewMapper guestReviewMapper;
    
    @Override
    public void createGuestReview(CreateGuestReviewRequest request) {

        if (guestReviewRepository.existsByGuestIdAndHotelIdAndReviewType(request.userId(), request.hotelId(), ReviewType.HOTEL)
                || guestReviewRepository.existsByGuestIdAndRoomIdAndReviewType(request.userId(), request.roomId(), ReviewType.ROOM)) {
            throw new GlobalException(Exceptions.GUEST_REVIEW_ALREADY_EXIST);
        }

        GuestReview review = guestReviewMapper.toGuestReview(request);
        guestReviewRepository.save(review);

    }

    @Override
    public void updateGuestReviewByUserId(Long guestId, UpdateGuestReviewRequest request) {

        GuestReview existingGuestReview = guestReviewRepository.findByGuestIdAndReviewType(guestId, request.reviewType())
                .orElseThrow(() -> new GlobalException(Exceptions.GUEST_REVIEW_NOT_FOUND_WITH_ID));

        if (guestReviewRepository.existsByGuestIdAndHotelIdAndReviewTypeAndIdNot(guestId, request.hotelId(), ReviewType.HOTEL, existingGuestReview.getId())
                || guestReviewRepository.existsByGuestIdAndRoomIdAndReviewTypeAndIdNot(guestId, request.roomId(), ReviewType.ROOM, existingGuestReview.getId())) {
            throw new GlobalException(Exceptions.GUEST_REVIEW_ALREADY_EXIST);
        }

        Hotel hotel = hotelRepository.findById(request.hotelId())
                .orElseThrow(() -> new GlobalException(Exceptions.HOTEL_NOT_FOUND));

        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(() -> new GlobalException(Exceptions.ROOM_NOT_FOUND));

        GuestReview guestReview = guestReviewMapper.updateGuestReview(existingGuestReview, request);

        guestReviewRepository.save(guestReview);
    }

    @Override
    public void deleteGuestReview(Long id) {

        guestReviewRepository.delete(findGuestReviewById(id));

    }


    @Override
    public List<GuestReviewResponse> getGuestReviewByUserId(Long guestId) {
        List<GuestReview> guestReviews = guestReviewRepository.findAllByGuestId(guestId);
        return guestReviews.stream()
                .map(guestReviewMapper::toGuestReviewResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<GuestReviewResponse> getAllGuestReviewsByHotel(Long hotelId) {

        List<GuestReview> hotelReviews =guestReviewRepository.findAllByHotelIdAndReviewType(hotelId, ReviewType.HOTEL);
        return hotelReviews.stream()
                .map(guestReviewMapper::toGuestReviewResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestReviewResponse> getAllGuestReviewByRoom(Long roomId) {
        List<GuestReview> roomReviews = guestReviewRepository.findAllByRoomIdAndReviewType(roomId, ReviewType.HOTEL);
        return roomReviews.stream()
                .map(guestReviewMapper::toGuestReviewResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GuestReview findGuestReviewById(Long id) {

        return guestReviewRepository.findById(id)
                .orElseThrow(() -> new GuestReviewException(Exceptions.GUEST_REVIEW_NOT_FOUND));

    }
}

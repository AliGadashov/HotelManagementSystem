package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestReviewResponse;
import com.gadashov.hotelmanagementsystem.model.entity.GuestReview;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:05 AM
 */

public interface GuestReviewService {
    void createGuestReview(CreateGuestReviewRequest request);

    void updateGuestReviewByUserId(Long guestId, UpdateGuestReviewRequest request);
    void deleteGuestReview(Long id);
    List<GuestReviewResponse> getGuestReviewByUserId(Long guestId);

    List<GuestReviewResponse> getAllGuestReviewsByHotel(Long hotelId);

    List<GuestReviewResponse> getAllGuestReviewByRoom(Long roomId);

    GuestReview findGuestReviewById(Long id);
}

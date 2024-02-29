package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.GuestReview;
import com.gadashov.hotelmanagementsystem.model.enums.ReviewType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:22 AM
 */

public interface GuestReviewRepository extends JpaRepository<GuestReview, Long> {
    List<GuestReview> findAllByGuestId(Long userId);

    List<GuestReview> findAllByHotelIdAndReviewType(Long hotelId, ReviewType reviewType);

    List<GuestReview> findAllByRoomIdAndReviewType(Long roomId, ReviewType reviewType);

    boolean existsByGuestIdAndHotelIdAndReviewType(Long aLong, Long aLong1, ReviewType reviewType);

    boolean existsByGuestIdAndRoomIdAndReviewType(Long aLong, Long aLong1, ReviewType reviewType);

    Optional<GuestReview> findByGuestIdAndReviewType(Long guestId, ReviewType reviewType);

    boolean existsByGuestIdAndHotelIdAndReviewTypeAndIdNot(Long guestId, Long aLong, ReviewType reviewType, Long id);

    boolean existsByGuestIdAndRoomIdAndReviewTypeAndIdNot(Long guestId, Long aLong, ReviewType reviewType, Long id);
}

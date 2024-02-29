package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdateGuestReviewRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.GuestReviewResponse;
import com.gadashov.hotelmanagementsystem.model.entity.GuestReview;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:28 AM
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GuestReviewMapper {
    @Named("toGuestReviewResponse")
    GuestReviewResponse toGuestReviewResponse (GuestReview guestReview);
    GuestReview toGuestReview (CreateGuestReviewRequest request);
    GuestReview updateGuestReview (@MappingTarget GuestReview guestReview, UpdateGuestReviewRequest request);

}

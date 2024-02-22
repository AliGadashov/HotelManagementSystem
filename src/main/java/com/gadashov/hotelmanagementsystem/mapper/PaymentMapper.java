package com.gadashov.hotelmanagementsystem.mapper;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.PaymentResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Payment;
import org.mapstruct.*;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {BookingMapper.class})
public interface PaymentMapper {


    @Named("toPaymentResponse")
    @Mapping(target = "bookingId", ignore = true)
    PaymentResponse toPaymentResponse (Payment payment);
    Payment toPayment (CreatePaymentRequest request);
    Payment updatePayment (@MappingTarget Payment payment, UpdatePaymentRequest request);

}

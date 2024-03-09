package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:33 PM
 */

public interface ConfirmationOtpRepository extends JpaRepository<ConfirmationOtp,Long> {
    @Query(value =
            "select o from ConfirmationOtp o " +
                    "join Guest g on o.guest = g " +
                    "where o.otp =:otp " +
                    "and o.expiredTime > current_timestamp "
    )
    Optional<ConfirmationOtp> findByOtp (Integer otp);
}

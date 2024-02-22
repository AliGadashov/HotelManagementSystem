package com.gadashov.hotelmanagementsystem.repository;

import com.gadashov.hotelmanagementsystem.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface StaffRepository extends JpaRepository<Staff,Long> {
}

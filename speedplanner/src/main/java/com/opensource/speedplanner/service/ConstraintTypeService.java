package com.opensource.speedplanner.service;


import com.opensource.speedplanner.model.ConstraintType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ConstraintTypeService {
    Page<ConstraintType> getAllConstraintType(Pageable pageable);
    ConstraintType createConstraintType(ConstraintType constraint);
    ConstraintType updateConstraintType(Long constraintId, ConstraintType constraint);
    ResponseEntity<?> deleteConstraintType(Long constraintId);
}


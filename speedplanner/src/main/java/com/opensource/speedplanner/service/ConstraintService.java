package com.opensource.speedplanner.service;


import com.opensource.speedplanner.model.Constraint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ConstraintService {
    Page<Constraint> getAllConstraint(Pageable pageable);
    Constraint createConstraint(Constraint constraint);
    Constraint updateConstraint(Long constraintId, Constraint constraint);
    ResponseEntity<?> deleteConstraint(Long constraintId);
}


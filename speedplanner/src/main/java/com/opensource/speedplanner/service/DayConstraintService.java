package com.opensource.speedplanner.service;


import com.opensource.speedplanner.model.DayConstraint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DayConstraintService {
    Page<DayConstraint> getAllDayConstraint(Pageable pageable);
    DayConstraint createDayConstraint(DayConstraint dayConstraint);
    DayConstraint updateDayConstraint(Long dayConstraintId, DayConstraint dayConstraint);
    ResponseEntity<?> deleteDayConstraint(Long dayConstraintId);
}

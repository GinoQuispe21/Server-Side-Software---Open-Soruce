package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.ConstraintType;
import com.opensource.speedplanner.model.DayConstraint;
import com.opensource.speedplanner.repository.ConstraintTypeRepository;
import com.opensource.speedplanner.repository.DayConstraintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class DayConstraintServiceImpl implements DayConstraintService{
    @Autowired
    private DayConstraintRepository dayConstraintRepository;

    @Override
    public Page<DayConstraint> getAllDayConstraint(Pageable pageable) {
        return dayConstraintRepository.findAll(pageable);
    }

    @Override
    public DayConstraint createDayConstraint(DayConstraint dayConstraint) {
        return dayConstraintRepository.save(dayConstraint);
    }

    @Override
    public DayConstraint updateDayConstraint(Long dayConstraintId, DayConstraint dayConstraintDetails) {
        return dayConstraintRepository.findById(dayConstraintId).map(dayConstraint -> {
            dayConstraintDetails.setType(dayConstraint.getType());
            return dayConstraintRepository.save(dayConstraint);
        }).orElseThrow(() -> new ResourceNotFoundException("DayConstraint", "Id", dayConstraintId));
    }

    @Override
    public ResponseEntity<?> deleteDayConstraint(Long dayConstraintId) {
        return dayConstraintRepository.findById(dayConstraintId).map(dayConstraint -> {
            dayConstraintRepository.delete(dayConstraint);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Constraint", "Id", dayConstraintId));
    }
}

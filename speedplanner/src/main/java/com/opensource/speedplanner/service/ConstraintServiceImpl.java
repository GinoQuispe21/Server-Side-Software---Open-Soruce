package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.Constraint;
import com.opensource.speedplanner.repository.ConstraintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConstraintServiceImpl implements ConstraintService {
    @Autowired
    private ConstraintRepository constraintRepository;

    @Override
    public Page<Constraint> getAllConstraint(Pageable pageable) {
        return constraintRepository.findAll(pageable);
    }

    @Override
    public Constraint createConstraint(Constraint constraint) {
        return constraintRepository.save(constraint);
    }

    @Override
    public Constraint updateConstraint(Long constraintId, Constraint constraintDetails) {
        return constraintRepository.findById(constraintId).map(constraint -> {
            constraintDetails.setType(constraint.getType());
            return constraintRepository.save(constraint);
        }).orElseThrow(() -> new ResourceNotFoundException("Constraint", "Id", constraintId));
    }

    @Override
    public ResponseEntity<?> deleteConstraint(Long constraintId) {
        return constraintRepository.findById(constraintId).map(constraint -> {
            constraintRepository.delete(constraint);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Constraint", "Id", constraintId));
    }
}

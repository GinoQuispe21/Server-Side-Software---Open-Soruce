package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.ConstraintType;
import com.opensource.speedplanner.repository.ClassroomRepository;
import com.opensource.speedplanner.repository.ConstraintTypeRepository;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class ConstraintTypeServiceImpl implements  ConstraintTypeService{
    @Autowired
    private ConstraintTypeRepository constraintTypeRepository;

    @Override
    public Page<ConstraintType> getAllConstraintType(Pageable pageable) {
        return constraintTypeRepository.findAll(pageable);
    }

    @Override
    public ConstraintType createConstraintType(ConstraintType constraint) {
        return constraintTypeRepository.save(constraint);
    }

    @Override
    public ConstraintType updateConstraintType(Long constraintId, ConstraintType constraint) {
        return constraintTypeRepository.findById(constraintId).map(constraintType -> {
            constraintType.setType(constraint.getType());
            return constraintTypeRepository.save(constraint);
        }).orElseThrow(() -> new ResourceNotFoundException("Constraint", "Id", constraintId));
    }

    @Override
    public ResponseEntity<?> deleteConstraintType(Long constraintId) {
        return constraintTypeRepository.findById(constraintId).map(constraintType -> {
            constraintTypeRepository.delete(constraintType);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Constraint", "Id", constraintId));
    }
}

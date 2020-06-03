package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.ProfessorConstraint;
import com.opensource.speedplanner.repository.ProfessorConstraintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class ProfessorConstraintServiceImpl implements ProfessorConstraintService {
    @Autowired
    ProfessorConstraintRepository professorConstraintRepository;

    @Override
    public ProfessorConstraint createProfessorConstraint(ProfessorConstraint professorConstraint) {
        return professorConstraintRepository.save(professorConstraint);
    }

    @Override
    public ProfessorConstraint getProfessorConstraintById(Long professorConstraintId) {
        return professorConstraintRepository.findById(professorConstraintId).
                orElseThrow(() -> new ResourceNotFoundException("Professor Constraint", "Id", professorConstraintId));
    }

    @Override
    public ProfessorConstraint updateProfessorConstraint(Long professorConstraintId, ProfessorConstraint professorConstraintDetails) {
        return professorConstraintRepository.findById(professorConstraintId).map(professorConstraint -> {
            professorConstraint.setType(professorConstraintDetails.getType());
            professorConstraint.setProfessorName(professorConstraintDetails.getProfessorName());
            return professorConstraintRepository.save(professorConstraint);
        }).orElseThrow(()-> new ResourceNotFoundException("Professor Constraint", "Id", professorConstraintId));
    }

    @Override
    public ResponseEntity<?> deleteProfessorConstraint(Long professorConstraintId) {
        return professorConstraintRepository.findById(professorConstraintId).map(professorConstraint -> {
            professorConstraintRepository.delete(professorConstraint);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Professor Constraint", "Id", professorConstraintId));
    }

    @Override
    public Page<ProfessorConstraint> getAllProfessorConstraints(Pageable pageable) {
        return professorConstraintRepository.findAll(pageable);
    }
}

package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.ProfessorConstraint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProfessorConstraintService {
    ProfessorConstraint createProfessorConstraint(ProfessorConstraint professorConstraint);
    ProfessorConstraint getProfessorConstraintById(Long professorConstraintId);
    ProfessorConstraint updateProfessorConstraint(Long professorConstraintId, ProfessorConstraint professorConstraint);
    ResponseEntity<?> deleteProfessorConstraint(Long professorConstraint);
    Page<ProfessorConstraint> getAllProfessorConstraints(Pageable pageable);
}

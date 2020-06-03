package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.ProfessorConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorConstraintRepository extends JpaRepository<ProfessorConstraint, Long> { }

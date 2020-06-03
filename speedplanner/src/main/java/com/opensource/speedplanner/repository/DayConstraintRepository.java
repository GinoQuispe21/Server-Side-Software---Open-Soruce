package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.DayConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayConstraintRepository extends JpaRepository<DayConstraint, Long> { }

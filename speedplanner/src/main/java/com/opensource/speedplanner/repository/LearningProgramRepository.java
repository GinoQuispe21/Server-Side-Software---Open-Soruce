package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.LearningProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningProgramRepository extends JpaRepository<LearningProgram, Long> {
}

package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.PossibleSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleScheduleRepository extends JpaRepository<PossibleSchedule, Long> { }

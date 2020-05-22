package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> { }

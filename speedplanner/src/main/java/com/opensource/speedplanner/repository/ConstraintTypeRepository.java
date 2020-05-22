package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.ConstraintType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintTypeRepository extends JpaRepository<ConstraintType , Long> {
}

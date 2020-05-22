package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.SectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRequestRepository extends JpaRepository<SectionRequest , Long> {
}

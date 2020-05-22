package com.opensource.speedplanner.repository;

import com.opensource.speedplanner.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section , Long> {

}

package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.PossibleSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PossibleScheduleService {
    PossibleSchedule getPossibleScheduleById(Long possibleScheduleId);
    PossibleSchedule createPossibleSchedule(PossibleSchedule possibleSchedule);
    PossibleSchedule updatePossibleSchedule(Long possibleScheduleId, PossibleSchedule possibleSchedule);
    ResponseEntity<?> deletePossibleSchedule(Long possibleSchedule);
    Page<PossibleSchedule> getAllPossibleSchedules(Pageable pageable);
}

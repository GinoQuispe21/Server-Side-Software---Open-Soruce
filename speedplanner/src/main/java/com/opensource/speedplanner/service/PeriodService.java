package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.Period;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PeriodService {
    Period getPeriodById(Long periodId);
    Period createPeriod(Period period);
    Period updatePeriod(Long periodId, Period period);
    ResponseEntity<?> deletePeriod(Long periodId);
    Page<Period> getAllPeriods(Pageable pageable);
}

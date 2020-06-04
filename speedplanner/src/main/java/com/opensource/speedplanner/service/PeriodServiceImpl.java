package com.opensource.speedplanner.service;
import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.LearningProgram;
import com.opensource.speedplanner.model.Period;
import com.opensource.speedplanner.repository.LearningProgramRepository;
import com.opensource.speedplanner.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodServiceImpl implements PeriodService {
    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private LearningProgramRepository learningProgramRepository;

    @Override
    public Period getPeriodById(Long periodId) {
        return periodRepository.findById(periodId).
                orElseThrow(() -> new ResourceNotFoundException("Period", "Id", periodId));
    }

    @Override
    public Period createPeriod(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public Period updatePeriod(Long periodId, Period periodDetails) {
        return periodRepository.findById(periodId).map(period -> {
            period.setCode(periodDetails.getCode());
            period.setStartDate(periodDetails.getStartDate());
            period.setStartDate(periodDetails.getEndDate());
            period.setInscriptionProcess(periodDetails.getInscriptionProcess());
            period.setLearningProgram(periodDetails.getLearningProgram());
            return periodRepository.save(period);
        }).orElseThrow(() -> new ResourceNotFoundException("Period", "Id", periodId));
    }

    @Override
    public ResponseEntity<?> deletePeriod(Long periodId) {
        return periodRepository.findById(periodId).map(period -> {
            periodRepository.delete(period);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Period", "Id", periodId));
    }

    @Override
    public Page<Period> getAllPeriods(Pageable pageable) {
        return periodRepository.findAll(pageable);
    }

    @Override
    public Page<Period> getAllPeriodsByLearningProgramId(Long learningProgramId, Pageable pageable) {
        return periodRepository.findAllByLearningProgramId(learningProgramId, pageable);
    }

    @Override
    public Period getByIdAndLearningProgramId(Long periodId, Long learningProgramId) {
        return periodRepository.findByIdAndLearningProgramId(periodId, learningProgramId).
                orElseThrow(() -> new ResourceNotFoundException("Period not found with Id: "+periodId+" " +
                        "and Learning Program Id: "+learningProgramId));
    }
}

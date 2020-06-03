package com.opensource.speedplanner.service;
import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.PossibleSchedule;
import com.opensource.speedplanner.repository.PossibleScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class PossibleScheduleServiceImpl implements PossibleScheduleService {

    @Autowired
    private PossibleScheduleRepository possibleScheduleRepository;

    @Override
    public PossibleSchedule getPossibleScheduleById(Long possibleScheduleId) {
        return possibleScheduleRepository.findById(possibleScheduleId).
                orElseThrow(() -> new ResourceNotFoundException("Possible Schedule", "Id", possibleScheduleId));
    }

    @Override
    public PossibleSchedule createPossibleSchedule(PossibleSchedule possibleSchedule) {
        return possibleScheduleRepository.save(possibleSchedule);
    }

    @Override
    public PossibleSchedule updatePossibleSchedule(Long possibleScheduleId, PossibleSchedule possibleScheduleDetails) {
        return possibleScheduleRepository.findById(possibleScheduleId).map(possibleSchedule ->{
            possibleSchedule.setCourses(possibleScheduleDetails.getCourses());
            possibleSchedule.setCredits(possibleScheduleDetails.getCredits());
            possibleSchedule.setFinalSchedule(possibleScheduleDetails.isFinalSchedule());
            possibleSchedule.setInscriptionProcess(possibleScheduleDetails.getInscriptionProcess());
            return possibleScheduleRepository.save(possibleSchedule);
        }).
                orElseThrow(()-> new ResourceNotFoundException("Possible Schedule", "Id", possibleScheduleId));
    }

    @Override
    public ResponseEntity<?> deletePossibleSchedule(Long possibleScheduleId) {
        return possibleScheduleRepository.findById(possibleScheduleId).map(possibleSchedule -> {
            possibleScheduleRepository.delete(possibleSchedule);
            return ResponseEntity.ok().build();
        }).
                orElseThrow(()-> new ResourceNotFoundException("Possible Schedule", "Id", possibleScheduleId));
    }

    @Override
    public Page<PossibleSchedule> getAllPossibleSchedules(Pageable pageable) {
        return possibleScheduleRepository.findAll(pageable);
    }
}

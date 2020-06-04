package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.Constraint;
import com.opensource.speedplanner.model.HourRangeConstraint;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;

 interface ConstraintService<T>{
     <T extends Constraint> T createConstraint(Long inscriptionProcessId, T constraint);
     //<T extends Constraint> T getConstraintByIdAndInscriptionProcessId(Long InscriptionProcessId,Long constraintId);
     //<T extends Constraint> Page<T> getAllConstraintsByInscriptionProcessId(Long InscriptionProcessId, Pageable pageable);
     //<T extends Constraint> T updateConstraint(Long InscriptionProcessId, Long constraintId, T constraint);
     //ResponseEntity<?> deleteConstraint(Long InscriptionProcessId, Long constraintId);
}
public interface HourRangeConstraintService {

}

class HourRangeConstraintServiceImpl implements ConstraintService<HourRangeConstraint>{

    @Override
    public <T extends Constraint> T createConstraint(Long inscriptionProcessId, T constraint) {
        return null;
    }
}

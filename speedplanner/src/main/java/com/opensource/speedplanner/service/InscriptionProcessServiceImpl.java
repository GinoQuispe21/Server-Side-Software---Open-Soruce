package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.EducationProvider;
import com.opensource.speedplanner.model.InscriptionProcess;
import com.opensource.speedplanner.repository.InscriptionProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InscriptionProcessServiceImpl implements InscriptionProcessService{

    @Autowired
    InscriptionProcessRepository inscriptionProcessRepository;

    @Override
    public InscriptionProcess createInscriptionProcess(InscriptionProcess inscriptionProcess) {
        return inscriptionProcessRepository.save(inscriptionProcess);
    }

    @Override
    public InscriptionProcess getInscriptionProcessById(Long inscriptionProcessId) {
        return inscriptionProcessRepository.findById(inscriptionProcessId)
                .orElseThrow(()-> new ResourceNotFoundException("InscriptionProcess", "Id", inscriptionProcessId));
    }

    @Override
    public Page<InscriptionProcess> getAllInscriptionProcesses(Pageable pageable) {
        return inscriptionProcessRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<?> deleteInscriptionProcess(Long inscriptionProcessId) {
        InscriptionProcess inscriptionProcess = getInscriptionProcessById(inscriptionProcessId);
        //throw exception if inscriptionProcessId isnt found
        inscriptionProcessRepository.delete(inscriptionProcess);
        return ResponseEntity.ok().build();
    }

    //Agregar update
}

package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.InscriptionProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface InscriptionProcessService {
    InscriptionProcess createInscriptionProcess(InscriptionProcess inscriptionProcess);
    InscriptionProcess getInscriptionProcessById(Long inscriptionProcessId);
    Page<InscriptionProcess> getAllInscriptionProcesses(Pageable pageable);
    //InscriptionProcess updateInscriptionProcess(Long inscriptionProcessId, InscriptionProcess inscriptionProcessDetails);
    ResponseEntity<?> deleteInscriptionProcess(Long inscriptionProcessId);
}

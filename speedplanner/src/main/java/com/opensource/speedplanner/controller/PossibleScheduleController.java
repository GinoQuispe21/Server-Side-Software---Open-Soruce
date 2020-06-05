package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.PossibleSchedule;
import com.opensource.speedplanner.resource.PossibleScheduleResource;
import com.opensource.speedplanner.service.PossibleScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PossibleScheduleController {
    @Autowired
    private ModelMapper mapper;

    private PossibleScheduleResource convertToResource(PossibleSchedule entity){
        return mapper.map(entity, PossibleScheduleResource.class);
    }

    private PossibleSchedule convertToEntity(PossibleScheduleResource resource){
        return mapper.map(resource, PossibleSchedule.class);
    }

    @GetMapping("/inscriptionProcesses/{inscriptionProcessId}/possibleSchedules/")
    public Page<PossibleSchedule> getAllPossibleSchedulesByInscriptionProcessId(){}
    //Terminar


}

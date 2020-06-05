package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.SectionRequest;
import com.opensource.speedplanner.resource.SaveSectionRequestResource;
import com.opensource.speedplanner.resource.SectionRequestResource;
import com.opensource.speedplanner.service.SectionRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SectionRequestController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SectionRequestService sectionRequestService;


    @PostMapping("/inscription_processes/{inscriptionProcessId}/section_requests")
    public SectionRequestResource createSectionRequest(@PathVariable(name = "inscriptionProcessId")Long inscriptionProcessId,
                                                       @Valid @RequestBody SaveSectionRequestResource resource){
        return  convertToResource(sectionRequestService.createSectionRequest(inscriptionProcessId , convertToEntity(resource)));
    }

    @PutMapping("/inscription_processes/{inscriptionProcessId}/section_requests/{sectionRequestId}")
    public SectionRequestResource updateSectionRequest(@PathVariable(name = "inscriptionProcessId")Long inscriptionProcessId,
                                                       @PathVariable(name = "sectionRequestId")Long sectionRequestId,
                                                       @Valid @RequestBody SaveSectionRequestResource resource){
        return  convertToResource(sectionRequestService.updateSectionRequest(inscriptionProcessId, sectionRequestId , convertToEntity(resource)));
    }

    @DeleteMapping("/inscription_processes/{inscriptionProcessId}/section_requests/{sectionRequestId}")
    public ResponseEntity<?> deleteSectionRequest(@PathVariable(name = "inscriptionProcessId") Long inscriptionProcessId,
                                                  @PathVariable(name = "sectionRequestId") Long sectionRequestId){
        return  sectionRequestService.deleteSectionRequest(inscriptionProcessId, sectionRequestId);
    }

    private  SectionRequest convertToEntity(SaveSectionRequestResource resource){
        return  mapper.map(resource, SectionRequest.class);
    }

    private SectionRequestResource convertToResource(SectionRequest entity){
        return mapper.map(entity, SectionRequestResource.class);
    }
}

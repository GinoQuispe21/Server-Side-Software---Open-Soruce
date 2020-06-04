package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.LearningProgram;
import com.opensource.speedplanner.resource.*;
import com.opensource.speedplanner.service.LearningProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LearningProgramController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private LearningProgramService learningProgramService;


    @PostMapping("/educationProviders/{educationProviderId}/learningPrograms")
    public LearningProgramResource createLearningProgram(@PathVariable Long educationProviderId,
                                                         @Valid @RequestBody SaveLearningProgramResource resource){
        LearningProgram learningProgram = convertToEntity(resource);
        return convertToResource(learningProgramService.createLearningProgram(educationProviderId, learningProgram));
    }

    @GetMapping("/educationProviders/{educationProviderId}/learningPrograms")
    public Page<LearningProgramResource> getAllLearningProgramsByEducationProviderId(
                                                                        @PathVariable Long educationProviderId,
                                                                        Pageable pageable){
        Page<LearningProgram> learningPrograms = learningProgramService.
                getAllLearningProgramsByEducationProvider(educationProviderId, pageable);
        List<LearningProgramResource> resources = learningPrograms.getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/educationProviders/{educationProviderId}/learningPrograms/{learningProgramId}")
    public LearningProgramResource getLearningProgramByIdAndEducationProviderId(@PathVariable Long educationProviderId,
                                                                                @PathVariable Long learningProgramId){
        return convertToResource(learningProgramService.getLearningProgramByIdAndEducationProviderId(educationProviderId, learningProgramId));
    }

    @PutMapping("/educationProviders/{educationProviderId}/learningPrograms/{learningProgramId}")
    public LearningProgramResource updateLearningProgram(@PathVariable Long educationProviderId,
                                                         @PathVariable Long learningProgramId,
                                                         @Valid @RequestBody SaveLearningProgramResource resource){
        LearningProgram learningProgram = convertToEntity(resource);
        return convertToResource(learningProgramService.updateLearningProgram(educationProviderId,
                learningProgramId, learningProgram));
    }

    @DeleteMapping("/educationProviders/{educationProviderId}/learningPrograms/{learningProgramId}")
    public ResponseEntity<?> deleteLearningProgram(@PathVariable Long educationProviderId,
                                                   @PathVariable Long learningProgramId){
        return learningProgramService.deleteLearningProgram(educationProviderId, learningProgramId);
    }


    private LearningProgram convertToEntity(SaveLearningProgramResource resource){
        return mapper.map(resource, LearningProgram.class);
    }
    private LearningProgramResource convertToResource(LearningProgram entity){
        return mapper.map(entity, LearningProgramResource.class);
    }
}

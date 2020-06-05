package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.PossibleSchedule;
import com.opensource.speedplanner.model.Professor;
import com.opensource.speedplanner.resource.ProfessorResource;
import com.opensource.speedplanner.service.ProfessorService;
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
@RequestMapping(name = "/api")
public class ProfessorController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessorService professorService;

    private ProfessorResource convertToResource(Professor entity){
        return mapper.map(entity, ProfessorResource.class);
    }

    private ProfessorResource convertToEntity(SaveProfessorResource resource){
        return mapper.map(resource, Professor.class);
    }

    @PostMapping("/professors/")
    public ProfessorResource createProfessor(@Valid @RequestBody SaveProfessorResource resource){
        return professorService.createProfessor(convertToEntity(resource));
    }

    @GetMapping("/professors/{professorId}")
    public ProfessorResource getProfessorById(@PathVariable(name = "professorId") Long professorId){
        return convertToResource(professorService.getProfessorById(professorId));
    }

    @PutMapping("/professors/{professorId}")
    public ProfessorResource updateProfessor(@PathVariable(name = "professorId") Long professorId,
                                             @Valid @RequestBody SaveProfessorResource resource){
        return convertToResource(professorService.updateProfessor(professorId, convertToEntity(resource)));
    }

    @GetMapping("/professors/")
    public Page<ProfessorResource> getAllProfessors(Pageable pageable){
        Page<Professor> professorPage = professorService.getAllProfessors(pageable);
    List<ProfessorResource> resources = professorPage.getContent().stream().map(this::convertToResource).
            collect(Collectors.toList());
    return new PageImpl<>(resources, pageable, resources.size());
    }

    @DeleteMapping("professors/{professorId}")
    public ResponseEntity<?> deleteProfessor(@PathVariable(name = "professorId") Long professorId){
        return professorService.deleteProfessor(professorId);
    }

}

package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.Section;
import com.opensource.speedplanner.resource.SaveSectionResource;
import com.opensource.speedplanner.resource.SectionResource;
import com.opensource.speedplanner.service.SectionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SectionController {
    @Autowired
    private ModelMapper mapper;

   @Autowired
    private SectionService sectionService;

    @PostMapping("/courses/{courseId}/sections")
    public  SectionResource createSection(@PathVariable(name = "courseId")Long courseId,
                                          @Valid @RequestBody SaveSectionResource resource
                                          ){
        return convertToResource(sectionService.createSection(courseId, convertToEntity(resource)));
    }

    @PutMapping("/courses/{courseId}/sections/{sectionId}")
    public SectionResource updateSection(@PathVariable(name = "courseId")Long courseId,
                                         @PathVariable(name = "sectionId") Long sectionId,
                                         @Valid @RequestBody SaveSectionResource resource){
        return convertToResource(sectionService.updateSection(courseId,sectionId,convertToEntity(resource)));
    }

    /*@DeleteMapping("/users/{userId}/roles/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable(name = "userId")Long userId,
                                        @PathVariable(name = "roleId")Long roleId
                                        ){
        return roleService.deleteRole(userId, roleId);
    }*/

    @DeleteMapping("/courses/{courseId}/sections/{sectionId}")
    public ResponseEntity<?> deleteSection(@PathVariable(name = "courseId") Long courseId,
                                           @PathVariable(name = "sectionId") Long sectionId){
        return sectionService.deleteSection(courseId,sectionId);
    }

    private Section convertToEntity(SaveSectionResource resource){
        return mapper.map(resource, Section.class);
    }

    private SectionResource convertToResource(Section entity){
        return mapper.map(entity, SectionResource.class);
    }
}

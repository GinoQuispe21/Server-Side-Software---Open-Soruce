package com.opensource.speedplanner.controller;

import com.opensource.speedplanner.model.Classroom;
import com.opensource.speedplanner.resource.ClassroomResource;
import com.opensource.speedplanner.resource.SaveClassroomResource;
import com.opensource.speedplanner.service.ClassroomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
public class ClassroomController {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClassroomService classroomService;

    @Operation(summary = "Get Classroom", description = "Get All Classrooms by Pages", tags = { "classrooms" })
    @GetMapping("/classrooms")
    public Page<ClassroomResource> getAllClassroom(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<Classroom> classroomPage = classroomService.getAllClassroom(pageable);
        List<ClassroomResource> resources = classroomPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Classroom by Id", description = "Get a Classroom by specifying Id", tags = { "classrooms" })
    @GetMapping("/classrooms/{id}")
    public ClassroomResource getClassroomById(
            @Parameter(description="Classroom Id")
            @PathVariable(name = "id") Long classroomId) {
        return convertToResource(classroomService.getClassroomById(classroomId));
    }

    @GetMapping("/courses/{courseId}/classrooms")
    public Page<ClassroomResource> getAllClassroomByCourseId(@PathVariable(name = "courseId") Long courseId, Pageable pageable) {
        Page<Classroom> classroomsPage = classroomService.getAllClassroomByCourseId(courseId, pageable);
        List<ClassroomResource> resources = classroomsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/classrooms")
    public ClassroomResource createClassroom(@Valid @RequestBody SaveClassroomResource resource)  {
        Classroom classroom = convertToEntity(resource);
        return convertToResource(classroomService.createClassroom(classroom));
    }

    @PutMapping("/classrooms/{id}")
    public ClassroomResource updatePost(@PathVariable(name = "id") Long classroomId, @Valid @RequestBody SaveClassroomResource resource) {
        Classroom classroom = convertToEntity(resource);
        return convertToResource(classroomService.updateClassroom(classroomId, classroom));
    }

    @DeleteMapping("/classrooms/{id}")
    public ResponseEntity<?> deleteClassroom(@PathVariable(name = "id") Long classroomId) {
        return classroomService.deleteClassroom(classroomId);
    }





    private ClassroomResource convertToResource(Classroom entity) {
        return mapper.map(entity, ClassroomResource.class);
    }  private Classroom convertToEntity(SaveClassroomResource resource) {
        return mapper.map(resource, Classroom.class);
    }

}

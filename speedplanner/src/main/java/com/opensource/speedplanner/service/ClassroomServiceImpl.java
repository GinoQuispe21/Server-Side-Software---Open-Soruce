package com.opensource.speedplanner.service;

import com.opensource.speedplanner.exception.ResourceNotFoundException;
import com.opensource.speedplanner.model.Classroom;
import com.opensource.speedplanner.model.Course;
import com.opensource.speedplanner.repository.ClassroomRepository;
import com.opensource.speedplanner.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Page<Classroom> getAllClassroom(Pageable pageable) {
        return classroomRepository.findAll(pageable);
    }

    @Override
    public Page<Classroom> getAllClassroomByCourseId(Long courseId, Pageable pageable) {
        return courseRepository.findById(courseId).map(course -> {
            List<Classroom> classrooms = course.getClassrooms();
            int classroomCount = classrooms.size();
            return new PageImpl<>(classrooms, pageable, classroomCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Course", "Id",courseId));
    }


    @Override
    public Classroom getClassroomById(Long classroomId) {
        return classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom", "Id", classroomId));
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Long classroomId, Classroom classroomDetails) {
        return classroomRepository.findById(classroomId).map(classroom -> {
            classroom.setClassroomName (classroomDetails.getClassroomName());
            return classroomRepository.save(classroom);
        }).orElseThrow(() -> new ResourceNotFoundException("Classroom", "Id", classroomId));
    }

    @Override
    public ResponseEntity<?> deleteClassroom(Long classroomId) {
        return classroomRepository.findById(classroomId).map(classroom -> {
            classroomRepository.delete(classroom);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Classroom", "Id", classroomId));
    }
}

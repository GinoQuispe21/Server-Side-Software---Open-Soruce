package com.opensource.speedplanner.service;

import com.opensource.speedplanner.model.Classroom;
import com.opensource.speedplanner.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClassroomService {
    Page<Classroom> getAllClassroom(Pageable pageable);
    Page<Classroom> getAllClassroomByCourseId(Long courseId, Pageable pageable);
    Classroom getClassroomById(Long classroomId);
    Classroom createClassroom(Classroom classroom);
    Classroom updateClassroom(Long classroomId, Classroom classroomDetails);
    ResponseEntity<?> deleteComment(Long classroomId);
}

package com.opensource.speedplanner.model;

import java.util.List;


public class EducationProvider { //Agregar anotaciones

    private Long id;

    private String name;

    private String academicPeriod;

    private int numberOfCareers;

    private List<LearningProgram> careerList;

    private List<Classroom> classrooms;

    private Subscription subscription;
}

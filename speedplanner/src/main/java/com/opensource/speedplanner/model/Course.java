package com.opensource.speedplanner.model;

import java.util.List;

public class Course {
    private Long id;

    private String code;

    private String name;

    private List<Section> sections;

    private Long totalNumberOfStudents;

    private boolean isOptional;

    private boolean isVirtual;

    private int semester;

    private int numberOfCredits;

    private int credits;

    private List<Course> requisites;
}

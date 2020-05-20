package com.opensource.speedplanner.model;

import java.util.List;

public class InscriptionProcess {
    private Long id;

    private List<Course> courses;

    private List<PossibleSchedule> possibleSchedules;

    private List<ConstraintType> constraints;

    private List<SectionRequest> sectionRequests;
}

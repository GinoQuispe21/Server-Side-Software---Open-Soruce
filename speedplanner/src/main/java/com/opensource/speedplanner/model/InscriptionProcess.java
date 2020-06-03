package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inscription_processes")
@Getter
@Setter
public class InscriptionProcess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private List<Course> courses;

    //private List<PossibleSchedule> possibleSchedules;

    //private List<Constraint> constraints;

    //private List<SectionRequest> sectionRequests;
	
	@OneToOne(mappedBy = "inscription_processes")
	private Period period;
}

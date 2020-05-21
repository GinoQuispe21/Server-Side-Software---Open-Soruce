package com.opensource.speedplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "education_providers")
@Getter
@Setter
public class EducationProvider { //Agregar anotaciones
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	@NotBlank
	@Size(max = 30)
    private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "academic_period_id", referencedColumnName = "id")
	@JsonIgnore
    private Period academicPeriod;

	@NotNull
	@NotBlank
    private int numberOfCareers;
		
    //private List<LearningProgram> careerList;

    //private List<Classroom> classrooms;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_id", referencedColumnName = "id")
	@JsonIgnore
    private Subscription subscription;

	@OneToOne(mappedBy = "education_providers")
	private Profile profile;
}

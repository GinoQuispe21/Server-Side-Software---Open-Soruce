package com.opensource.speedplanner.model;

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
}

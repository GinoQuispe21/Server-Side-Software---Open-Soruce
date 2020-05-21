package com.opensource.speedplanner.model;

import java.util.List;

@Entity
@Table(name = "learning_programs")
@Getter
@Setter
public class LearningProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotBlank
    private Long numberOfCourses;

    //private List<Period> periodList;
	
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
            @JoinTable(name = "curriculums_courses",
            joinColumns = {@JoinColumn(name = "learning_program_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
            @JsonIgnore
    private List<Course> curriculum;
	
	@OneToOne(mappedBy = "learning_programs")
    Statistic statistic;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_provider_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private EducationProvider educationProvider;
}

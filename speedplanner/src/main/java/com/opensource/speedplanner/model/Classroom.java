package com.opensource.speedplanner.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "classrooms")
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true)
    public String Code;

    @NotBlank
    @NotNull
    @Size(max = 50)
    public String type;

    @NotNull
    @NotBlank
    public  int capacity;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "classrooms_courses",
            joinColumns = {@JoinColumn(name = "classroom_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    @JsonIgnore
    List<Course> courses;

    //Porque EducationProvider tiene List<Classroom>
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "education_provider_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private EducationProvider educationProvider;
}
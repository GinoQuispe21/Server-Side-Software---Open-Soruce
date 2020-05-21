package com.opensource.speedplanner.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 5)
    @Column(unique=true)
    private String code;

    @NotBlank
    @NotNull
    @Size(max = 25)
    private String name;

    @NotBlank
    @NotNull
    private List<Section> sections;

    @NotBlank
    @NotNull
    @Size(max = 40)
    private Long totalNumberOfStudents;

    @NotNull
    private boolean isOptional;

    @NotNull
    private boolean isVirtual;

    @NotBlank
    @NotNull
    private int semester;

    @NotBlank
    @NotNull
    private int numberOfCredits;

    @NotBlank
    @NotNull
    private int credits;

    @NotBlank
    @NotNull
    private List<Course> requisites;
}
package com.opensource.speedplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String lastNames;

    @NotBlank
    @NotNull
    private boolean gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_provider_id", referencedColumnName = "id")
    @JsonIgnore
    private EducationProvider educationProvider;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_Program_id", referencedColumnName = "id")
    @JsonIgnore
    private LearningProgram learningProgram;

    @NotBlank
    @NotNull
    private int semester;

    @NotBlank
    @NotNull
    private Long idNumber;

    @OneToOne(mappedBy = "profile")
    User user;
}

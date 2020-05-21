package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="professor_constraints)")
@Getter
@Setter
    public class ProfessorConstraint {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @NotNull
    private String type;

    @NotBlank
    @NotNull
    @Size(max=70)
    private String professorName;

    @OneToOne(mappedBy = "professor_constraints")
    ConstraintType constraintType;
    }

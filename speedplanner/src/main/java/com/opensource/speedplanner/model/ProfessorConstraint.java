package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="professor_constraints")
@PrimaryKeyJoinColumn(name = "professor_constraint_id")
@Getter
@Setter
public class ProfessorConstraint extends Constraint{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max=70)
    private String professorName;

    @OneToOne(mappedBy = "professor_constraints")
    Constraint constraint;
}

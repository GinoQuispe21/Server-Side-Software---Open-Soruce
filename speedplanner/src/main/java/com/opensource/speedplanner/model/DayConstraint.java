package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "day_constraints")
@Getter
@Setter
public class DayConstraint {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String type;

    @NotNull
    private boolean[] days;

    @OneToOne(mappedBy = "day_constraint")
    private ConstraintType constraintType;
}

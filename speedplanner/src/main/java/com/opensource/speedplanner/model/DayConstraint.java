package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "day_constraints")
@PrimaryKeyJoinColumn(name = "day_constraint_id")
@Getter
@Setter
public class DayConstraint extends Constraint{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private static boolean[] days = new boolean[7];

    @OneToOne(mappedBy = "day_constraint")
    private Constraint constraint;
}

package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;
import sun.jvm.hotspot.gc.shared.Generation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "constraint_types")
@Getter
@Setter
public class ConstraintType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private int type;
}
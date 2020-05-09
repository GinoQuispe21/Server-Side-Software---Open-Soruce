package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profiles")
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @NotNull
    @NotBlank
    @Size(max = 35)
    private String names;

    @NotNull
    @NotBlank
    @Size(max = 35)
    private String lastNames;

    @NotNull
    @NotBlank
    private boolean gender;

    //EducationProvider educationProvider;

    @NotNull
    @NotBlank
    private int semester;

    @NotNull
    @NotBlank
    private long idNumber;
}

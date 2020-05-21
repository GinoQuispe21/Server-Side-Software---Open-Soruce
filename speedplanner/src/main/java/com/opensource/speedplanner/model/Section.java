package com.opensource.speedplanner.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sections")
@Getter
@Setter
public class Section { //agregar anotaciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 4)
    private String sectionName;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String venue;

    @NotBlank
    @NotNull
    private int vacancy;

    @NotBlank
    @NotNull
    private int registeredStudents;

    @NotBlank
    @NotNull
    private int numberOfHours;

    //SectionSchedules list
}
package com.opensource.speedplanner.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sectionSchedules")
@Getter
@Setter
public class Classroom {
    @Id
    public String Code;

    @NotBlank
    @NotNull
    public String type;

    @NotNull
    @NotBlank
    public  int capacity;
}

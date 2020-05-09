package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "sectionSchedules")
@Getter
@Setter
public class SectionSchedule {
    @Id
    public String code;

    @NotBlank
    public Date startTime;
    @NotBlank
    public Date endTime;

    @NotNull
    @NotBlank
    public  int numberOfHours;

    @NotBlank
    public String Day;
}

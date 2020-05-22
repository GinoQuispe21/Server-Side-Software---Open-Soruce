package com.opensource.speedplanner.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "section_schedules")
@Getter
@Setter
public class SectionSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String code;

    @NotBlank
    public Date startTime;

    @NotBlank
    public Date endTime;

    @NotNull
    @NotBlank
    public  int numberOfHours;

    @NotBlank
    public String day;
}
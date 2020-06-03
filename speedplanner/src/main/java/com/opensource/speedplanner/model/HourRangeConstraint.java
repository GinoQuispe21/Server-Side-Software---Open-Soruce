package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "hour_range_constraints")
@PrimaryKeyJoinColumn(name = "hour_range_constraint_id")
@Getter
@Setter
public class HourRangeConstraint extends Constraint{

    private Date startTime;

    private Date endTime;
	
    private int numberOfHours;
}

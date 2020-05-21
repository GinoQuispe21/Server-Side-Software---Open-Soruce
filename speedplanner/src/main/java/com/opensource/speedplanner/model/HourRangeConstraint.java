package com.opensource.speedplanner.model;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "hour_range_constraints")
@Getter
@Setter
public class HourRangeConstraint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	@NotBlank	
    private String type;
	

    private Date startTime;

    private Date endTime;
	
    private int numberOfHours;
}

package com.opensource.speedplanner.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name ="subscriptions")
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private Double cost;

    @NotNull
    @NotBlank
    private Date startDate;

    @NotNull
    @NotBlank
    private Date endDate;

    @OneToOne(mappedBy = "subscriptions")
    EducationProvider educationProvider;
}

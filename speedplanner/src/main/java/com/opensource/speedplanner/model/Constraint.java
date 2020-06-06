package com.opensource.speedplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "constraints")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Constraint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private int type;

    //@NotBlank
    //@NotNull
    //private ConstraintType nextConstraint;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "next_constraint_id", referencedColumnName = "id")
    @JsonIgnore
    private Constraint nextConstraint;

    @NotNull
    private boolean activeFilter;

    //Porque InscriptionProcess tiene List<Constraint>
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inscription_process_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InscriptionProcess inscriptionProcess;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_id", referencedColumnName = "id")
    private DayConstraint dayConstraint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_id", referencedColumnName = "id")
    private HourRangeConstraint hourRangeConstraint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_id", referencedColumnName = "id")
    private ProfessorConstraint professorConstraint;*/

}
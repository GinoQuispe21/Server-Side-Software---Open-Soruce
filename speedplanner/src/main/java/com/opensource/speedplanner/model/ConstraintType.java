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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_type_id", referencedColumnName = "id")
    private DayConstraint dayConstraint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_type_id", referencedColumnName = "id")
    private HourRangeConstraint hourRangeConstraint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "constraint_type_id", referencedColumnName = "id")
    private ProfessorConstraint professorConstraint;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inscription_process_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private InscriptionProcess inscriptionProcess;
}
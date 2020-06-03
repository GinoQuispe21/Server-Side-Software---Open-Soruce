package com.opensource.speedplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    //@NotBlank
    //@NotNull
    //private ConstraintType nextConstraint;

    @NotBlank
    public boolean ActiveFilter;

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
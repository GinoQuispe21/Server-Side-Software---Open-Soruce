package com.opensource.speedplanner.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveProfessorConstraintResource {
    @NotBlank
    @NotNull
    String professorName;
}

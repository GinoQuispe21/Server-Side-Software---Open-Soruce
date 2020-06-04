package com.opensource.speedplanner.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveConstraintResource {

    @NotNull
    @NotBlank
    public int type;

    @NotNull
    public boolean activeFilter;
}

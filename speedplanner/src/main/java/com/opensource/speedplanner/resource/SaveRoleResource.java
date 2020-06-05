package com.opensource.speedplanner.resource;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SaveRoleResource {
    @NotNull
    @NotBlank
    private int type;
}

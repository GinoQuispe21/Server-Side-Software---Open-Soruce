package com.opensource.speedplanner.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveClassroomResource {

    @NotBlank
    @NotNull
    public String classroomName;

    @NotBlank
    @NotNull
    public String type;

    @NotBlank
    @NotNull
    public int capacity;
}

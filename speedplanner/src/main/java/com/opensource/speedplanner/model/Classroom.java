package com.opensource.speedplanner.model;
import lombok.Getter;
import lombok.Setter;
import sun.jvm.hotspot.gc.shared.Generation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "classrooms")
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true)
    public String Code;

    @NotBlank
    @NotNull
    @Size(max = 50)
    public String type;

    @NotNull
    @NotBlank
    public  int capacity;

    @NotNull
    @NotBlank
    private List<Course> courses;
}
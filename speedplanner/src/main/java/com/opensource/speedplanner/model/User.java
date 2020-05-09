package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 25)
    @Column(unique = true)
    private String email;
}

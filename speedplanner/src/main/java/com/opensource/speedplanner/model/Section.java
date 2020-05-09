package com.opensource.speedplanner.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "sections")
@Getter
@Setter
public class Section {
   @Id
   public String code;

   @Lob
   @NotBlank
   public String venue;

   @NotNull
   @NotBlank
   public int vacancy;

   @NotNull
   public int registeredStudents;

   @NotNull
   @NotBlank
   public int numberOfHours;
}

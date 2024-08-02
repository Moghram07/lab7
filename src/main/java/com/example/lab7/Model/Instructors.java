package com.example.lab7.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instructors {
    @NotNull(message = "id can not be null")
    private int id;

    @NotNull(message = "name can not be null")
    private String name;

    @NotNull(message = "course can not be null")
    private String course;

    @NotNull(message = "number of students can not be null")
    @Min(value = 15, message = "students must be 15 or more")
    private int numberOfStudents;

    @NotNull(message = "academy id can not be null")
    private int academyId;

    @AssertFalse
    private boolean onLeave;

}

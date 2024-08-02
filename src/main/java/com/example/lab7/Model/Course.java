package com.example.lab7.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "course name can not be null")
    private String name;

    @NotNull(message = "course code can not be null")
    @Min(value = 3, message = "course code should be 3 or more characters")
    private int code;

    @NotNull(message = "course description can not be null")
    @Size(min = 10, message = "description must be 10 characters or more")
    private String description;

    @NotNull(message = "course location can not be null")
    private String location;

    @NotNull(message = "academy id can not be null")
    private int academyId;

    @AssertFalse
    private boolean isMandatory;

}

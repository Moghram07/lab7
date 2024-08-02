package com.example.lab7.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Academy {
    @NotNull(message = "id can not be null")
    private int academyId;

    @NotNull(message = "name can not be null")
    private String name;

    @NotNull(message = "address can not be null")
    private String address;

    @NotNull(message = "phone can not be null")
    @Pattern(regexp = "^011[\\d]{7}", message = "phone must start with 011 and 7 other numbers")
    private String phone;

    @NotNull(message = "email can not be null")
    @Pattern(regexp = "^[\\w]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "invalid email format")
    private String email;

}

package com.hikmetsuicmez.spring_data_jpa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Firstname alanı boş bırakılamaz!")
    @Size(min = 3, max = 10)
    private String firstName;

    @Size(min = 3, max = 15)
    private String lastName;
    private Date dateOfBirth;
}

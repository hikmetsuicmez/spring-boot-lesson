package com.hikmetsuicmez.spring_data_jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<T> {

    private HttpStatus status;
    private String id;
    private Date errorTime;
    private T errors;
}

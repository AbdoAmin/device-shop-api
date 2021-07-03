package com.abdelrahman.amin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestError {
    private Integer status;

    private String message;

    private LocalDateTime timestamp;

    private String path;

}

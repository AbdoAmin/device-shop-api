package com.abdelrahman.amin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimCardDTO {

    private String id;

    private Integer operatorCode;

    private String country;

    private String status;
}

package com.abdelrahman.amin.dto;

import com.abdelrahman.amin.entity.SimCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDTO {

    private Integer id;

    private String status;

    private Double temperature;

    private SimCardDTO simCard;

}

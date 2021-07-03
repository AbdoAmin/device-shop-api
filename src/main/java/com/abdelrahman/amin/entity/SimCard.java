package com.abdelrahman.amin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sim_card")
public class SimCard {

    @Id
    private String id;

    private Integer operatorCode;

    private String country;

    private String status;

    @OneToOne(mappedBy = "simCard",fetch = FetchType.LAZY)
    private Device device;
}

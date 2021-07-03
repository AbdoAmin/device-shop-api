package com.abdelrahman.amin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String status;

    private Double temperature;

    @OneToOne
    @JoinColumn(name = "sim_id", referencedColumnName = "id")
    private SimCard simCard;
}

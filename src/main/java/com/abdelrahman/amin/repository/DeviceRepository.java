package com.abdelrahman.amin.repository;

import com.abdelrahman.amin.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer>{

    List<Device> getAllBySimCardStatus(String status);

    List<Device> getAllByStatusAndTemperatureBetween(String status, Double temperatureFrom, Double temperatureTo);
}

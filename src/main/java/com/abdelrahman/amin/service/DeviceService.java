package com.abdelrahman.amin.service;

import com.abdelrahman.amin.dto.DeviceDTO;

import java.util.List;


public interface DeviceService {

    List<DeviceDTO> getAllDevicesWaitingActivation();
    List<DeviceDTO> getAllAvailableDevicesSorted();
    DeviceDTO updateConfiguration(Integer deviceId, DeviceDTO deviceDTO);
}

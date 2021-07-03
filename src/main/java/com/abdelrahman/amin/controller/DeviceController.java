package com.abdelrahman.amin.controller;

import com.abdelrahman.amin.api.DeviceAPI;
import com.abdelrahman.amin.dto.DeviceDTO;
import com.abdelrahman.amin.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class DeviceController implements DeviceAPI {

    private DeviceService deviceService;

    @Override
    public List<DeviceDTO> getAllDevicesWaitingActivation() {
        return deviceService.getAllDevicesWaitingActivation();
    }

    @Override
    public List<DeviceDTO> getAllAvailableDevicesSorted() {
        return deviceService.getAllAvailableDevicesSorted();
    }

    @Override
    public DeviceDTO updateConfiguration(Optional<Integer> deviceId,DeviceDTO deviceDTO) {
        return deviceService.updateConfiguration(deviceId.orElse(0), deviceDTO);
    }

}

package com.abdelrahman.amin.api;

import com.abdelrahman.amin.dto.DeviceDTO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/device")
public interface DeviceAPI {

    @GetMapping("/waiting-activation")
    List<DeviceDTO> getAllDevicesWaitingActivation();

    @GetMapping("/available")
    List<DeviceDTO> getAllAvailableDevicesSorted();

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    DeviceDTO updateConfiguration(@PathVariable("id") Optional<Integer> deviceId, @RequestBody DeviceDTO deviceDTO);
}

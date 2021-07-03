package com.abdelrahman.amin.service.impl;

import com.abdelrahman.amin.dto.DeviceDTO;
import com.abdelrahman.amin.entity.Device;
import com.abdelrahman.amin.enums.DeviceStatusTypes;
import com.abdelrahman.amin.enums.SIMCardStatusTypes;
import com.abdelrahman.amin.repository.DeviceRepository;
import com.abdelrahman.amin.service.DeviceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;
    private ModelMapper modelMapper;
    private ModelMapper modelMapperSkipNull;

    public List<DeviceDTO> getAllDevicesWaitingActivation() {
        List<Device> deviceList = deviceRepository.getAllBySimCardStatus(SIMCardStatusTypes.WAITING_ACTIVATION.name());
        return deviceList.stream().map(device -> modelMapper.map(device, DeviceDTO.class)).collect(Collectors.toList());

    }

    public List<DeviceDTO> getAllAvailableDevicesSorted() {
        List<Device> deviceList = deviceRepository.getAllByStatusAndTemperatureBetween(DeviceStatusTypes.READY.name(),-25.0,85.0);
        return deviceList.stream().map(device -> modelMapper.map(device, DeviceDTO.class)).collect(Collectors.toList());
    }

    public DeviceDTO updateConfiguration(Integer deviceId, DeviceDTO deviceDTO) {
        Device device = deviceRepository.getById(deviceId);
        modelMapperSkipNull.map(deviceDTO,device);
        return modelMapper.map(deviceRepository.save(device),DeviceDTO.class);
    }
}

package com.abdelrahman.amin.controller;

import com.abdelrahman.amin.dto.DeviceDTO;
import com.abdelrahman.amin.dto.SimCardDTO;
import com.abdelrahman.amin.service.DeviceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeviceControllerTest {
    @Mock
    public DeviceService deviceService;
    @InjectMocks
    public DeviceController deviceController;

    private List<DeviceDTO> deviceDTOS;
    private DeviceDTO deviceDTO;


    @Before
    public void setUp() {
        deviceDTO = new DeviceDTO(1, "ready", 80.0,
                new SimCardDTO("01000000", 60202, "Egypt", "active"));
        deviceDTOS = Arrays.asList(
                deviceDTO);

    }

    @Test
    public void getAllDevicesWaitingActivation_getAll_ReturnDeviceList() {
        Mockito.when(deviceService.getAllDevicesWaitingActivation()).thenReturn(deviceDTOS);
        List<DeviceDTO> allDevicesWaitingActivation = deviceController.getAllDevicesWaitingActivation();
        assertEquals(1, allDevicesWaitingActivation.size());
    }

    @Test
    public void prepareHomePage() {
        Mockito.when(deviceService.getAllAvailableDevicesSorted()).thenReturn(deviceDTOS);
        List<DeviceDTO> allDevicesWaitingActivation = deviceController.getAllAvailableDevicesSorted();
        assertEquals(1, allDevicesWaitingActivation.size());
    }

    @Test
    public void updateConfiguration() {
        Mockito.when(deviceService.updateConfiguration(Mockito.anyInt(), Mockito.any(DeviceDTO.class))).thenReturn(deviceDTO);
        DeviceDTO deviceDTO = deviceController.updateConfiguration(Optional.of(1), this.deviceDTO);
        assertEquals(1, deviceDTO.getId());
    }

}
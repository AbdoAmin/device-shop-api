package com.abdelrahman.amin.service.impl;

import com.abdelrahman.amin.dto.DeviceDTO;
import com.abdelrahman.amin.entity.Device;
import com.abdelrahman.amin.entity.SimCard;
import com.abdelrahman.amin.repository.DeviceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceImplTest {
    @Mock
    private DeviceRepository deviceRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private ModelMapper modelMapperSkipNull;
    @InjectMocks
    private DeviceServiceImpl deviceService;
    private List<Device> deviceList;
    private Device device;

    @Before
    public void setUp() {
        device = new Device();
        device.setId(1);
        device.setStatus( "ready");
        device.setTemperature(80.0);
        device.setSimCard(new SimCard());
        deviceList = Arrays.asList(device);

    }

    @Test
    public void getAllDevicesWaitingActivation() {
        Mockito.when(deviceRepository.getAllBySimCardStatus(Mockito.anyString())).thenReturn(deviceList);
        List<DeviceDTO> allDevicesWaitingActivation = deviceService.getAllDevicesWaitingActivation();
        assertEquals(1, allDevicesWaitingActivation.size());
    }

    @Test
    public void getAllAvailableDevicesSorted() {
        Mockito.when(deviceRepository.getAllByStatusAndTemperatureBetween(Mockito.anyString(),Mockito.anyDouble(),Mockito.anyDouble())).thenReturn(deviceList);
        Mockito.when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(new DeviceDTO());
        List<DeviceDTO> allDevicesWaitingActivation = deviceService.getAllAvailableDevicesSorted();
        assertEquals(1, allDevicesWaitingActivation.size());
    }

    @Test
    public void updateConfiguration() {
        Mockito.when(deviceRepository.getById(Mockito.anyInt())).thenReturn(device);
        Mockito.when(deviceRepository.save(Mockito.any())).thenReturn(device);
        Mockito.when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(new DeviceDTO());
        DeviceDTO deviceDTO = deviceService.updateConfiguration(1,new DeviceDTO());
        assertNotNull(deviceDTO);
    }
}
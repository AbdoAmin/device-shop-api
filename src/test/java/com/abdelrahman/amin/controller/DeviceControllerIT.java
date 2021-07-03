package com.abdelrahman.amin.controller;

import com.abdelrahman.amin.dto.DeviceDTO;
import com.abdelrahman.amin.dto.SimCardDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import sun.security.util.SecurityConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithMockUser(roles = {"ADMIN"})
@AutoConfigureMockMvc
public class DeviceControllerIT {

    public static final String URL_PREFIX = "/api/v1/device";
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

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
    public void getAllDevicesWaitingActivation_getAll_ReturnDeviceList() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX + "/waiting-activation");
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void prepareHomePage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get(URL_PREFIX + "/available");
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateConfiguration() throws Exception {
        String jsonContent = objectMapper.writeValueAsString(
                new DeviceDTO(1, "ACTIVE", 50.0, new SimCardDTO()));
        MockHttpServletRequestBuilder requestBuilder =
                put(URL_PREFIX + "/1").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent);
        this.mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
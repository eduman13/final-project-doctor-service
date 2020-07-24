package com.ironhack.finalprojectdoctorservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.finalprojectdoctorservice.model.dto.AddressDTO;
import com.ironhack.finalprojectdoctorservice.model.dto.DoctorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DoctorControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void findById() throws Exception {
        this.mockMvc.perform(get("/doctor/find_by_id/1"))
                .andExpect(status().isOk());
    }

    @Test
    void updateAddress() throws Exception {
        AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet("Avenida Ámerica");
            addressDTO.setPortal(20);
            addressDTO.setNumber(5);
        this.mockMvc.perform(put("/doctor/update_address/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addressDTO)))
                .andExpect(status().isNoContent());
    }

    @Test
    void findAll() throws Exception {
        this.mockMvc.perform(get("/doctor/find_all"))
                .andExpect(status().isOk());
    }

    @Test
    void createDoctor() throws Exception {
        DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setId((long) 45);
            doctorDTO.setName("Eduardo");
            doctorDTO.setSurnames("García Espeso");
            doctorDTO.setSchoolNumber("676876545455T");
            doctorDTO.setStreet("Avenida de Ámerica");
            doctorDTO.setPortal(20);
            doctorDTO.setNumber(5);
        this.mockMvc.perform(post("/doctor/create_doctor")
                .content(objectMapper.writeValueAsString(doctorDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
package com.MarineData.controller;

import com.demo.model.MarineData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MarineDataControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addMarineData() throws Exception {
        MarineData marineDataToAdd = new MarineData(1L, "Location2", "23.5");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/marine-data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(marineDataToAdd)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void updateMarineData() throws Exception {
        Long id = 1L;
        MarineData updatedData = new MarineData(id, "Location2", "28.2");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .put("/marine-data/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedData)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void deleteMarineData() throws Exception {
        Long id = 0L;


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .delete("/marine-data/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
}

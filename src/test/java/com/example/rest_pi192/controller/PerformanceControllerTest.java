package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Performance;
import com.example.rest_pi192.repository.PerformanceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PerformanceController.class)
public class PerformanceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    public PerformanceRepository performanceRepository;

    @Test
    public void findAll() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/performance")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.performance").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.performance[*].performanceId").isNotEmpty());
    }

    @Test
    public void findById() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/performance/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.performanceId").value(1));
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/performance")
                .content(asJsonString(new Performance(1, "Балет", "20.01.2020", "18:00", 1, 1, "status")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.performanceId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

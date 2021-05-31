package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Hall;
import com.example.rest_pi192.repository.HallRepository;
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
@WebMvcTest(HallController.class)
public class HallControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    public HallRepository hallRepository;

    @Test
    public void findAll() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/hall")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hall").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hall[*].hallId").isNotEmpty());
    }

    @Test
    public void findById() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/hall/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hallId").value(1));
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/hall")
                .content(asJsonString(new Hall(1, "главный", 200)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hallId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

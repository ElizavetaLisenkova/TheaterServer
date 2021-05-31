package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Troup;
import com.example.rest_pi192.repository.TroupRepository;
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
@WebMvcTest(TroupController.class)
public class TroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    public TroupRepository troupRepository;

    @Test
    public void findAll() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/troup")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.troup").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.troup[*].troupId").isNotEmpty());
    }

    @Test
    public void findById() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/troup/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.troupId").value(1));
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/troup")
                .content(asJsonString(new Troup(1, "труппа")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.troupId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

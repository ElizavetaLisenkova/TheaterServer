package com.example.rest_pi192.controller;


import com.example.rest_pi192.entity.Actor;
import com.example.rest_pi192.repository.ActorRepository;
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
@WebMvcTest(ActorController.class)
public class ActorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    public ActorRepository actorRepository;

    @Test
    public void findAll() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/actor")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.actor").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.actor[*].actorId").isNotEmpty());
    }

    @Test
    public void findById() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/actor/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.actorId").value(1));
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/actor")
                .content(asJsonString(new Actor(1, 1, "Лисенкова Елизавета Андреевна")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.actorId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

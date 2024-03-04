package com.alianza.clients.controller;

import com.alianza.clients.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"name\":\"Pepito Prueba\",\n" +
                                "\t\"email\":\"prueba@gmail.com\",\n" +
                                "\t\"phone\":3216548656,\n" +
                                "\t\"start_date\":\"20/05/2019\",\n" +
                                "\t\"end_date\":\"20/05/2019\"\n" +
                                "}"
                                ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                \t"shared_key":"jgutierrez",
                                \t"name":"Pepito Prueba",
                                \t"email":"prueba@gmail.com",
                                \t"phone": 3216548656,
                                \t"start_date":"20/05/2019",
                                \t"end_date":"20/05/2019"
                                }"""))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
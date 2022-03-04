package com.cda.pc.api;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cda.pc.model.Computer;
import com.cda.pc.repository.ComputerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest(ComputerRestController.class)
public class Computertest {
	

	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
	
    @MockBean
    ComputerRepository repository;
    
    Computer Computer_1 = new Computer(1L,"Nom 1", "Mark 1", 50, 42,"Category 1");
    
    Computer Computer_2 = new Computer(2L,"Nom 2", "Mark 2", 50, 42, "Category 2");
    
    
    @Test
    public void getAll_success() throws Exception {
    	List<Computer> computer = new ArrayList<Computer>(Arrays.asList(Computer_1, Computer_2));
        
        Mockito.when(repository.findAll()).thenReturn(computer);
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/computer")
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect((ResultMatcher) status().isOk());
    }
    
    @Test
	public void getComputerById_success() throws Exception {
    	Mockito.when(repository.findById(Computer_1.getId())).thenReturn(Optional.of(Computer_1));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/computer/view/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Nom 1")));
	}

    
    @Test
    public void create_success() throws Exception {
        Computer computer = new Computer("Nom 1", "Mark 1", 50, 42,"Category 1");

        Mockito.when(repository.save(computer)).thenReturn(computer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/computer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(computer));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
            
        }
    
    @Test
    public void doublons() throws Exception{
    	List<Computer> computer = new ArrayList<Computer>(Arrays.asList(Computer_1, Computer_2));     
        Mockito.when(repository.findAll()).thenReturn(computer);        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/computer")
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect((ResultMatcher) status().isOk());
    	
    	
    }

}

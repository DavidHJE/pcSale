package com.cda.pc.api;

import static org.hamcrest.Matchers.hasSize;
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
public class Computertest2 {
	

	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
	
    @MockBean
    ComputerRepository computerRepo;
    
    Computer Computer_1 = new Computer(1L,"Name GS 69 stealth", "Mark MSI", 1268 ,1,"Category Pc portable");
    Computer Computer_2 = new Computer(2L,"Name Pc config", "Mark LDLC", 2467 ,1,"Category Pc fixe");
    
    @Test
    public void getAllComputer_success() throws Exception {
    	List<Computer> listComputer = new ArrayList<Computer>(Arrays.asList(Computer_1, Computer_2));
        
        Mockito.when(computerRepo.findAll()).thenReturn(listComputer);
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/computer")
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect((ResultMatcher) status().isOk())
        		.andExpect(jsonPath("$[0].name", is("Name GS 69 stealth")));
    }
    
   

}

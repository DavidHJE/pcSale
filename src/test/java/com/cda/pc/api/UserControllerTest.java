package com.cda.pc.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cda.pc.model.User;
import com.cda.pc.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
	
    @MockBean
    UserRepository userRepo;
    
    User USER_1 = new User(1L, "Name 1", "Pseudo 1", "Email 1", "Password 1");
    
    User USER_2 = new User(2L, "Name 2", "Pseudo 2", "Email 2", "Password 2");
    
    User USER_3 = new User(3L, "Name 3", "Pseudo 3", "Email 3", "Password 3");
    
    
    @Test
    public void getAllUser_success() throws Exception {
    	List<User> users = new ArrayList<User>(Arrays.asList(USER_1, USER_2, USER_3));
        
        Mockito.when(userRepo.findAll()).thenReturn(users);
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status());
    }



	
}

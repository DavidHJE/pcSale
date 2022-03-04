package com.cda.pc.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

import com.cda.pc.model.Comment;
import com.cda.pc.model.Computer;
import com.cda.pc.model.User;
import com.cda.pc.repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest(CommentRestController.class)
public class CommentControllerTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	CommentRepository commentRepository;

	Date dateJour = new Date();
	User USER = new User(1L, "Name 1", "Pseudo 1", "Email 1", "Password 1");
	Computer COMPUTER = new Computer("Name computer", "asus", 2000, 5, "Portable");
	
	Comment COMMENT_1 = new Comment("Commentaire 1", dateJour , false, USER, COMPUTER);
	
	Comment COMMENT_2 = new Comment("Commentaire 2", dateJour , false, USER, COMPUTER);
	
	Comment COMMENT_3 = new Comment("Commentaire 3", dateJour , false, USER, COMPUTER);
	
	Comment COMMENT_4 = new Comment(1L, "Commentaire 4", dateJour , false, USER, COMPUTER);

	@Test
	public void getAllComment() throws Exception {
		List<Comment> comments = new ArrayList<Comment>(Arrays.asList(COMMENT_1, COMMENT_2, COMMENT_3));

		Mockito.when(commentRepository.findAll()).thenReturn(comments);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/comment").contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) status().isOk()).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].comment", is("Commentaire 1")));
	}

	@Test
	public void getAllCommentEmpty() throws Exception {
		List<Comment> comments = new ArrayList<Comment>();

		Mockito.when(commentRepository.findAll()).thenReturn(comments);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/comment").contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) status().isNoContent());
	}

	@Test
	public void getCommentById() throws Exception {
		Mockito.when(commentRepository.findById(COMMENT_4.getId())).thenReturn(Optional.of(COMMENT_4));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/comment/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()));
	}
	
	@Test
    public void createComment() throws Exception {
		
		Comment comment = new Comment("Commentaire 1", dateJour , false, USER, COMPUTER);

        Mockito.when(commentRepository.save(comment)).thenReturn(comment);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/comment/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(comment));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andReturn();
        }
}

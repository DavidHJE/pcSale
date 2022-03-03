package com.cda.pc.api;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cda.pc.Models.Comment;
import com.cda.pc.repository.CommentRepository;

@RestController
public class CommentRestController {

	
	@Autowired
	private CommentRepository repository;
	
	//find all
	@GetMapping("/api/comment")
	public Iterable<Comment> findAll(){
		return repository.findAll();
	}
	
	//find by id
	@GetMapping("/api/comment/{id}")
	public Comment findById(@PathVariable("id") Long id){
		return (Comment) repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment Id:" + id));
	}
	
	//add a comment
	@PostMapping("/api/comment")
	public ResponseEntity<Comment> addcomment(@RequestBody Comment newComment) {
	   
		try {
			Date dateJour = new Date();
		      Comment _comment = repository
		          .save(new Comment(newComment.getComment(), dateJour , false));
		      return new ResponseEntity<>(_comment, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	  }

	
	//update
	 @PutMapping("/api/comment/{id}")
	  public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment comment) {
	    Optional<Comment> commentData = repository.findById(id);
	    if (commentData.isPresent()) {
	    	Date dateJour = new Date();
		    Comment _comment = commentData.get();
		    _comment.setComment(comment.getComment());
		    _comment.setUpdated_date(dateJour);
	      
	      return new ResponseEntity<>(repository.save(_comment), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	//delete a comment
	@DeleteMapping("/api/comment/{id}")
	  public void deleteComment(@PathVariable("id") Long id) {
	   repository.deleteById(id);
	  }
}

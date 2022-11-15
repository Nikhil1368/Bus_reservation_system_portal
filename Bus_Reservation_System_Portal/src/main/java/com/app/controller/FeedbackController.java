package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.LoginException;
import com.app.exceptions.feedbackException;
import com.app.model.Feedback;
import com.app.service.FeedBackService;

@RestController
@RequestMapping("/feedback/")
public class FeedbackController {
	
	@Autowired
	private FeedBackService fService;
	@GetMapping("/viewAll")
    public ResponseEntity<List <Feedback>> getAllFeedback()throws feedbackException {
		
        return new ResponseEntity<List <Feedback>>(fService.viewAllFeedBack(),HttpStatus.OK);
    }
	
	@PostMapping("/save/{busid}/{key}")
    public ResponseEntity<Feedback> createFeedback(@Valid @RequestBody Feedback feedback,@PathVariable("busid") Integer busid,@PathVariable("key") String key)throws feedbackException, LoginException {
		
		Feedback Feedback2 = fService.addFeedBack(feedback,busid,key);
		
        return new ResponseEntity<Feedback>(Feedback2,HttpStatus.OK);
    } 
	
	@GetMapping("/find/{feedbackId}")
    public ResponseEntity<Feedback> getRouteById(@PathVariable int feedbackId)throws feedbackException{
		
		Feedback feedback = fService.viewFeedBack(feedbackId);
		
		return new ResponseEntity<Feedback>(feedback,HttpStatus.OK); 
    }
		
	
	@PutMapping("/update{key}")
    public ResponseEntity<Feedback> updateRouteById(@Valid @RequestBody Feedback feedback,@PathVariable("key") String key)throws feedbackException, LoginException {
		
		return new ResponseEntity<Feedback>(fService.updateFeedBack(feedback,key),HttpStatus.OK);
    }
	

}

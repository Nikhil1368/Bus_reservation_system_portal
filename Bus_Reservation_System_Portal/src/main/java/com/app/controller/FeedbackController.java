package com.app.controller;

import java.util.List;

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
	
	@PostMapping("/save")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback)throws feedbackException {
		
		Feedback Feedback2 = fService.addFeedBack(feedback);
		
        return new ResponseEntity<Feedback>(Feedback2,HttpStatus.OK);
    } 
	
	@GetMapping("/find/{feedbackId}")
    public ResponseEntity<Feedback> getRouteById(@PathVariable int feedbackId)throws feedbackException{
		
		Feedback feedback = fService.viewFeedBack(feedbackId);
		
		return new ResponseEntity<Feedback>(feedback,HttpStatus.OK); 
    }
		
	
	@PutMapping("/update")
    public ResponseEntity<Feedback> updateRouteById(@RequestBody Feedback feedback)throws feedbackException {
		
		return new ResponseEntity<Feedback>(fService.updateFeedBack(feedback),HttpStatus.OK);
    }
	

}

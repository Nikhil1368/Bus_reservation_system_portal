package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.exceptions.feedbackException;
import com.app.model.Feedback;
import com.app.repository.BusRepo;
import com.app.repository.FeedbackRepo;
import com.app.repository.UserRepo;

@Service
public class FeedBackServiceImlp implements FeedBackService{

	@Autowired
	private FeedbackRepo fRepo;
	
	@Override
	public Feedback addFeedBack(Feedback feedback) throws feedbackException {
		
		Feedback feedback2 = fRepo.save(feedback);
		if(feedback2!=null) {
			return feedback2;	
		}else {
			throw new feedbackException("feedback is done...");
		}
			
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback) throws feedbackException {
		
		Feedback Feedback2 = new Feedback();
		Optional < Feedback > optional = fRepo.findById(feedback.getFeedbackId());
	        if (optional.isPresent()) {
	        	Feedback2.setDriverRating(feedback.getDriverRating());
	        	Feedback2.setServiceRating(feedback.getServiceRating());
	        	Feedback2.setOverallRating(feedback.getOverallRating());
	        	Feedback2.setComments(feedback.getComments());
	        	Feedback2.setFeedbackDate(feedback.getFeedbackDate());
	            return fRepo.save(Feedback2);
     	        } else {
	            throw new feedbackException("feedback is not done...");
     	        }
	}

	@Override
	public Feedback viewFeedBack(int feedbackld) throws feedbackException {
		Optional < Feedback > optional = fRepo.findById(feedbackld);
		Feedback feedback = null;
	        if (optional.isPresent()) {
	        return feedback = optional.get();
	        } else {
	            throw new feedbackException(" Feedback not found for id :: " + feedbackld);
	        }
	}

	@Override
	public List<Feedback> viewAllFeedBack() throws feedbackException {
		
		 List<Feedback> feedback = fRepo.findAll();
		    
		    if(feedback!=null) {
		    	return feedback;	
		    }else {
		    	throw new feedbackException("feedback not found");
		    }
	}

}

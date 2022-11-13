package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.LoginException;
import com.app.exceptions.feedbackException;
import com.app.model.Bus;
import com.app.model.CurrentUserSession;
import com.app.model.Feedback;
import com.app.model.User;
import com.app.repository.BusRepo;
import com.app.repository.FeedbackRepo;
import com.app.repository.SessionRepo;
import com.app.repository.UserRepo;

@Service
public class FeedBackServiceImlp implements FeedBackService{

	@Autowired
	private FeedbackRepo fRepo;
	
	@Autowired
	private SessionRepo sr;
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private BusRepo br;
	
	@Override
	public Feedback addFeedBack(Feedback feedback,Integer busId,String key) throws feedbackException,LoginException {
		
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		
		User user = ur.findById(cus.getUserId()).orElseThrow(()->new feedbackException("No user found..."));
		
		 Optional<Bus> nbus = br.findById(busId);
		 
		 if(!nbus.isPresent())
		 {
			 throw new feedbackException("No bus present with id : "+busId);
		 }
		
		feedback.setBus(nbus.get());
		feedback.setUsers(user);
		feedback.setFeedbackDate(LocalDate.now());
		Feedback feedback2 = fRepo.save(feedback);
		
		return feedback2;
		
			
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback,String key) throws feedbackException,LoginException  {
		
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		
		User user = ur.findById(cus.getUserId()).orElseThrow(()->new feedbackException("No user found..."));
		
		Optional<Feedback> op = fRepo.findById(feedback.getFeedbackId());
		if(op.isPresent())
		{
			Feedback fb = op.get();
			
			 Optional<Bus> nbus = br.findById(fb.getBus().getBusId());
			 
			 if(!nbus.isPresent())
			 {
				 throw new feedbackException("No bus present with id : "+fb.getBus().getBusId());
			 }
			 
			 fb.setBus(nbus.get());
			 
			 fb.setFeedbackDate(LocalDate.now());
			 
			 return fRepo.save(feedback);
			
			
		}
		
		throw new feedbackException("No feedback found!");
		
		
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

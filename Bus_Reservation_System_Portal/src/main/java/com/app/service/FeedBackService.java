package com.app.service;

import java.util.List;

import com.app.exceptions.feedbackException;
import com.app.model.Feedback;

public interface FeedBackService {
   public Feedback	addFeedBack(Feedback feedback)throws feedbackException ; 
   public Feedback	updateFeedBack(Feedback feedback)throws feedbackException; 
   public Feedback	viewFeedBack(int feedbackld)throws feedbackException; 
   public List<Feedback> viewAllFeedBack()throws feedbackException;
}

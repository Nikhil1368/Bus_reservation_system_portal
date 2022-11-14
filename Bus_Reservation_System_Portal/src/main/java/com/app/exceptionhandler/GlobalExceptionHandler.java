package com.app.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.app.exceptions.AdminException;
import com.app.exceptions.BusException;
import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.exceptions.RouteException;
import com.app.exceptions.UserException;
import com.app.exceptions.feedbackException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(AdminException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<ErrorDetails> busExceptionHandler(BusException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(feedbackException.class)
	public ResponseEntity<ErrorDetails> feedbackExceptionHandler(feedbackException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<ErrorDetails> reservationExceptionHandler(ReservationException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<ErrorDetails> routeExceptionHandler(RouteException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException se,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(se.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception se,WebRequest req)
//	{
//		ErrorDetails ed = new ErrorDetails();
//		ed.setTimestamp(LocalDateTime.now());
//		ed.setMessage(se.getMessage());
//		ed.setDetails(req.getDescription(false));
//		
//		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhfe,WebRequest req)
	{
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(nhfe.getMessage());
		ed.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> mANVExceptionHandler(MethodArgumentNotValidException manve)
	{
	   ErrorDetails ed = new ErrorDetails();
	   ed.setTimestamp(LocalDateTime.now());
	   ed.setMessage(manve.getMessage());
	   ed.setDetails(manve.getBindingResult().getFieldError().getDefaultMessage());
	   
	   return  new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	

}

package com.capgemini.onlinetestmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.error.UserException;
import com.capgemini.onlinetestmanagement.services.UserServiceInterface;

@CrossOrigin(origins="http://localhost:8018")
@RestController
public class UserController {
	
	
	@Autowired
	private UserServiceInterface  userService;
	
	//@CrossOrigin(origins="http://localhost:8018")
	@GetMapping("/viewallUser")
	public ResponseEntity<List<User>> getallUser() {
		List<User> userlist = userService.showAllUsers();
		return new ResponseEntity<List<User>>(userlist , HttpStatus.OK);
		
	}
	
	
	//@CrossOrigin(origins="http://localhost:8018")
	@PostMapping(value="/Registration")
	public ResponseEntity<String> addAccount(@Valid @RequestBody User user, BindingResult br) throws UserException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors= br.getFieldErrors();
			for(FieldError error:errors)
				err +=error.getDefaultMessage() +"<br/>";
			throw new UserException(err);
		}
		try {
			userService.addAccount(user);
			return new ResponseEntity<String>("Account added", HttpStatus.OK);
			
		}
		catch(DataIntegrityViolationException ex) {
			throw new UserException("ID already exists");
		}
	}
	
	
	//@CrossOrigin(origins="http://localhost:8018")
	@PostMapping(value="/User/{userId}/{password}")
	public ResponseEntity<String> login(@Valid @RequestParam Long userId,@Valid @RequestParam String password,BindingResult br)throws UserException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors =br.getFieldErrors();
			for(FieldError error:errors)
				err+=error.getDefaultMessage()+"<br/>";
			throw new UserException(err);
		}
	try{
		userService.loginId(userId,password);
		return new ResponseEntity<String>("Login done", HttpStatus.OK);
	}
	catch(DataIntegrityViolationException ex)
	{
		throw new UserException("User doesn't exists");
	}
			
	}
	
	
	
	
	//@CrossOrigin(origins="http://localhost:8018")	
	@DeleteMapping(value = "/deleteuser/{id}")
	public ResponseEntity<String> deleteuser(@Valid @RequestParam int userId)
			throws UserException {
		try {
			userService.deleteuser(userId);
			return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new UserException("User ID not exists");
		}
	}
	}
	

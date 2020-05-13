package com.capgemini.onlinetestmanagement.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagement.dao.Userdao;
import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.error.RecordNotFoundException;
import com.capgemini.onlinetestmanagement.error.UserException;




@Service
@Transactional
public class UserServiceImp implements UserServiceInterface {

	
	
	@Autowired
	private Userdao userdao;

	@Override
	public boolean addAccount(User user) {
		User Result= userdao.save(user);
		if(Result!=null) {
			return true;
		}
		else
			return false;
	}
	
	@Autowired
	
public void login(Long userId,String password)throws UserException{
	{
		Object obj=userdao.findById(userId);
		
		if(obj ==null) {
			throw new RecordNotFoundException("Wrong Id");
		}
		else if(((User) obj).getPassword().equals(password) && ((User) obj).getIsAdmin()==false) {
			throw new UserException("login with student") ;
		}
		else if(((User) obj).getPassword().equals(password) && ((User) obj).getIsAdmin()==true) {
			throw new UserException("login with Admin");
		}
		else {
		 throw new Error("Password Incorrect");
		}
	}
	}
	


	

	
	@Override
	public List<User> showAllUsers() 
	{
		return userdao.findAll();
	}
		
	

	@Override
    public void deleteuser(long userId) {
		userdao.deleteById(userId);
	}

	


	
}

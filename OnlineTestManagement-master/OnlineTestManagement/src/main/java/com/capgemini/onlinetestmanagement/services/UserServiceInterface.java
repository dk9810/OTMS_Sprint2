package com.capgemini.onlinetestmanagement.services;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.onlinetestmanagement.entity.User;

public interface UserServiceInterface {
	
	boolean addAccount(User user);
    List<User> showAllUsers();
	void deleteuser(long userId);
	
	void loginId(@Valid Long userId, @Valid String password);
	
}

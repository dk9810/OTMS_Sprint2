package com.capgemini.onlinetestmanagement.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinetestmanagement.entity.User;

@Repository
public interface Userdao extends JpaRepository<User,Long> {

	/**User findUserByUserName(String userName);*/
	 

}


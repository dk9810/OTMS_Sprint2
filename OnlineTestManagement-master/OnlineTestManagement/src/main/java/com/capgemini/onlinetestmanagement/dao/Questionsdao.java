package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.Questions;

@Repository
public interface Questionsdao extends JpaRepository<Questions, Integer >{

}


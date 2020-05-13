package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.Test1;

@Repository
public interface Testdao extends JpaRepository<Test1,Integer> {

}
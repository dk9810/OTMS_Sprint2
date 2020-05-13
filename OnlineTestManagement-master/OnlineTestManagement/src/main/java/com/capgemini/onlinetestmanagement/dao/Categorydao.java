package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.Category;

@Repository
public interface Categorydao extends JpaRepository<Category,Integer> {

}
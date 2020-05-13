package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="Category")
public class Category {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Category_id")
@NotNull
@Positive
private int id;

@Column(name="Category_name")
@NotNull(message="Categoryname not be nulled")
private String name;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Category(@NotNull @Positive int id, @NotNull(message = "Categoryname not be nulled") String name) {
	super();
	this.id = id;
	this.name = name;
}

public Category() {
	super();
	// TODO Auto-generated constructor stub
}



}
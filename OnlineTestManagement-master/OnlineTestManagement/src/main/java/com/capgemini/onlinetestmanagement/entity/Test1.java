package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Test")
public class Test1 {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Id")
@NotNull(message="Username not be nulled")
@Positive
private int testId;

@Column(name="Title")
private String testTitle;

@Column(name="Duration")
private LocalTime testDuration;

@OneToMany
//@JoinColumn(name="Question", nullable=false)
private Set<Questions> testquestions;// collection mapping using many too one


@Column(name="TotalMarks")
private BigDecimal testTotalMarks;

@Column(name="MarksScored")
private BigDecimal testMarksScored;



@Column(name="StartTime")
private LocalDateTime startTime;

@Column(name="Endtime")
@Future
private LocalDateTime endTime;

public int getTestId() {
	return testId;
}

public void setTestId(int testId) {
	this.testId = testId;
}

public String getTestTitle() {
	return testTitle;
}

public void setTestTitle(String testTitle) {
	this.testTitle = testTitle;
}

public LocalTime getTestDuration() {
	return testDuration;
}

public void setTestDuration(LocalTime testDuration) {
	this.testDuration = testDuration;
}

public Set<Questions> getTestquestions() {
	return testquestions;
}

public void setTestquestions(Set<Questions> testquestions) {
	this.testquestions = testquestions;
}

public BigDecimal getTestTotalMarks() {
	return testTotalMarks;
}

public void setTestTotalMarks(BigDecimal testTotalMarks) {
	this.testTotalMarks = testTotalMarks;
}

public BigDecimal getTestMarksScored() {
	return testMarksScored;
}

public void setTestMarksScored(BigDecimal testMarksScored) {
	this.testMarksScored = testMarksScored;
}



public LocalDateTime getStartTime() {
	return startTime;
}

public void setStartTime(LocalDateTime startTime) {
	this.startTime = startTime;
}

public LocalDateTime getEndTime() {
	return endTime;
}

public void setEndTime(LocalDateTime endTime) {
	this.endTime = endTime;
}

public Test1(@NotNull(message = "Username not be nulled") @Positive int testId, String testTitle, LocalTime testDuration,
		Set<Questions> testquestions, BigDecimal testTotalMarks, BigDecimal testMarksScored, Questions currentQuestion,
		LocalDateTime startTime, @Future LocalDateTime endTime) {
	super();
	this.testId = testId;
	this.testTitle = testTitle;
	this.testDuration = testDuration;
	this.testquestions = testquestions;
	this.testTotalMarks = testTotalMarks;
	this.testMarksScored = testMarksScored;
	this.startTime = startTime;
	this.endTime = endTime;
}

public Test1() {
	super();
	// TODO Auto-generated constructor stub
}



}

package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Arrays;

@Entity
@Table(name="Questions")
public class Questions {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="QId")
@NotNull(message="Username not be nulled")
@Positive
private  int questionId;

@Column(name="QTitle")
private String questionTitle;

@Column(name="Qoptions")
private String[] questionOptions;

@Column(name="QAnswers")
private int questionAnswer;

@Column(name="Qmarks")
private BigDecimal questionMarks;

@Column(name="ChoosenAns")
private int chooseAnswer;

@Column(name="marks")
private BigDecimal marksScored;

public int getQuestionId() {
return questionId;
}

public void setQuestionId(int questionId) {
this.questionId = questionId;
}

public String getQuestionTitle() {
return questionTitle;
}

public void setQuestionTitle(String questionTitle) {
this.questionTitle = questionTitle;
}

public String[] getQuestionOptions() {
return questionOptions;
}

public void setQuestionOptions(String[] questionOptions) {
this.questionOptions = questionOptions;
}

public int getQuestionAnswer() {
return questionAnswer;
}

public void setQuestionAnswer(int questionAnswer) {
this.questionAnswer = questionAnswer;
}

public BigDecimal getQuestionMarks() {
return questionMarks;
}

public void setQuestionMarks(BigDecimal questionMarks) {
this.questionMarks = questionMarks;
}

public int getChooseAnswer() {
return chooseAnswer;
}

public void setChooseAnswer(int chooseAnswer) {
this.chooseAnswer = chooseAnswer;
}

public BigDecimal getMarksScored() {
return marksScored;
}

public void setMarksScored(BigDecimal marksScored) {
this.marksScored = marksScored;
}

public Questions(int questionId, String questionTitle, String[] questionOptions, int questionAnswer,
BigDecimal questionMarks, int chooseAnswer, BigDecimal marksScored) {
super();
this.questionId = questionId;
this.questionTitle = questionTitle;
this.questionOptions = questionOptions;
this.questionAnswer = questionAnswer;
this.questionMarks = questionMarks;
this.chooseAnswer = chooseAnswer;
this.marksScored = marksScored;
}

@Override
public String toString() {
return "Question [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionOptions="
+ Arrays.toString(questionOptions) + ", questionAnswer=" + questionAnswer + ", questionMarks="
+ questionMarks + ", chooseAnswer=" + chooseAnswer + ", marksScored=" + marksScored + "]";
}

}

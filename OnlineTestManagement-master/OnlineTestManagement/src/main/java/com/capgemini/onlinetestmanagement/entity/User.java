package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="User5")
@DynamicUpdate(true)
@DynamicInsert(true)
public class User {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="userId")
@NotNull(message="must not be null")
@Positive
private Long userId;

@Column(name="userName")
@NotNull(message="Username not be nulled")
@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank scpace is allowed" )
private String UserName;

@Column(name="password")
@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$")
private String password;

/**@OneToOne
@JoinColumn(name="userTest")
private Test1 userTest;*/

@Column(name="isAdmin")
private Boolean isAdmin;

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getUserName() {
	return UserName;
}

public void setUserName(String userName) {
	UserName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

/*public Test1 getUserTest() {
	return userTest;
}

public void setUserTest(Test1 userTest) {
	this.userTest = userTest;}*/


public Boolean getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(Boolean isAdmin) {
	this.isAdmin = isAdmin;
}

public User(@NotNull(message = "must not be null") @Positive Long userId,
		@NotNull(message = "Username not be nulled") @Pattern(regexp = "A-z") String userName,
		@Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})") String password, Test1 userTest,
		Boolean isAdmin) {
	super();
	this.userId = userId;
	UserName = userName;
	this.password = password;
	/**this.userTest = userTest;*/
	this.isAdmin = isAdmin;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}


}


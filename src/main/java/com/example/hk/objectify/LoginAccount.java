 
package com.example.hk.objectify;
 
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index; 

import java.lang.String;
import java.util.Date;
 
@Entity
public class LoginAccount { 
	@Id public Long id = new Date().getTime();

	public String email;
	public String fullName;  
	public String password;
	@Index public Date date = new Date();

	/**
	 * Simple constructor just sets the date
	 **/
	public LoginAccount() { }
 
	/**
	* Simple constructor just sets the date
	**/
	public LoginAccount(String fullName, String email, String password) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
 

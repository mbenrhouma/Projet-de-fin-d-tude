package com.cynapsys.mail;

import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator
{
	public  String login;
	public  String password;
	
	public SMTPAuthenticator(String login, String password){
		
		super();
		this.login=login;
		this.password=password;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PasswordAuthentication getPasswordAuthentication()
	  {
	            return new PasswordAuthentication(login, password);
	  }
	    
}

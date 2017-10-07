package com.example.hk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.hk.objectify.LoginAccount;
import com.googlecode.objectify.ObjectifyService;
 
public class LoginActionController implements Controller{
	
	/** The logger. */
	protected static org.apache.log4j.Logger logger = Logger.getLogger(LoginActionController.class);
	private String redirectHtml;

 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			LoginAccount loginAccount = new LoginAccount(request.getParameter("fullName"),request.getParameter("email"),request.getParameter("password"));
			ObjectifyService.ofy().save().entity(loginAccount).now();
			request.getSession().setAttribute("id", loginAccount.getId());
		}
		catch (Exception e){
			logger.error("[handleRequest]", e);
		}
		response.sendRedirect(getRedirectHtml());
		return null;
	}


	public String getRedirectHtml() {
		return redirectHtml;
	}


	public void setRedirectHtml(String redirectHtml) {
		this.redirectHtml = redirectHtml;
	}
	
}

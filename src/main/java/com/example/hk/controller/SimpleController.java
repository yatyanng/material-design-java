package com.example.hk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.hk.objectify.LoginAccount;
import com.googlecode.objectify.ObjectifyService;



public class SimpleController implements Controller{
	
	protected static org.apache.log4j.Logger logger = Logger.getLogger(SimpleController.class);
	private String forwardJsp;

	public String getForwardJsp() {
		return forwardJsp;
	}

	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("session user-id: "+request.getSession().getAttribute("id"));
		if (request.getSession().getAttribute("id") != null){
			LoginAccount loginAccount = ObjectifyService.ofy().load().type(LoginAccount.class).id((long) request.getSession().getAttribute("id")).now();
			request.setAttribute("loginAccount", loginAccount);
		}
		return new ModelAndView(forwardJsp,null);
	}
	
}

package com.avsan.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class Logout implements  LogoutSuccessHandler  {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("Logout  1");
		if (authentication != null){
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			System.out.println("Logout  sucess");
			}		
		String URL = request.getContextPath();
		response.setStatus(HttpStatus.OK.value());
		response.sendRedirect(URL);
	}

}
 
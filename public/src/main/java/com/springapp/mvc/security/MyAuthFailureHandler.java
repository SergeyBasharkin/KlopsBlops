package com.springapp.mvc.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 11.04.2016.
 */
public class MyAuthFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String url = httpServletRequest.getHeader("Referer");
        //httpServletRequest.setAttribute("auth",false);
        if (url.contains("?auth=true")){
            url=url.replace("?auth=true","");
        }
        httpServletResponse.sendRedirect(url.contains("?auth=false")?url:url+"?auth=false");
    }
}

package com.springapp.mvc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 11.04.2016.
 */
public class MyAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String url = httpServletRequest.getHeader("Referer");

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        //httpServletRequest.getSession().setAttribute("auth",true);
        if (url.contains("auth=false")){
            url=url.replace("?auth=false","");
        }else if (url.contains("auth=true")){
            url=url.replace("?auth=true","");
        }
        httpServletResponse.sendRedirect(url+"?auth=true");
    }
}

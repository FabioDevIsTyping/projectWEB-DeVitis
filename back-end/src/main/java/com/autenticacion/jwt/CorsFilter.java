package com.autenticacion.jwt;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
         throws IOException, ServletException {
      HttpServletResponse response = (HttpServletResponse) res;
      HttpServletRequest request = (HttpServletRequest) req;
      
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Credentials", "true");
      
      // Allow all request methods
      response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      
      if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
         // Handle OPTIONS request
         response.setStatus(HttpServletResponse.SC_OK);
      } else {
         chain.doFilter(req, res);
      }
   }
}

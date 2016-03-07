package com.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, PUT, GET, OPTIONS, DELETE");
		// response.setHeader("Access-Control-Allow-Headers",
		// "x-requested-with");
		response.setHeader("Access-Control-Allow-Headers",
				"x-auth-token, x-requested-with");
		response.setHeader("Access-Control-Max-Age", "3600");

		HttpServletRequest request = (HttpServletRequest) req;
		if (!request.getMethod().equals("OPTIONS")) {
			chain.doFilter(req, res);
		} else {
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}
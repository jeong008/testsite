package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter extends HttpServlet {
	
	private void doFilter(HttpServletRequest requset, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException{ 
		// TODO Auto-generated method stub
		String uri = requset.getRequestURI();
		
		
		
	}

}

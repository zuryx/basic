package com.zuryx.app.basic;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
	
	private static final long serialVersionUID = -1415352225860174283L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Properties props = new Properties();		
		props.load(getClass().getResourceAsStream("/dev_credentials.properties"));
		req.setAttribute("environment", props.get("user"));
		final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(req, resp);
	}
}

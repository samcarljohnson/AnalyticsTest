package com.scjohnson.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.log4j.Logger;

import com.scjohnson.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside the GET method.");
		LoginService login = new LoginService();
		String u = request.getParameter("username");
		String e = request.getParameter("email");;
		String p = request.getParameter("password");;
		login.registerUser(u, e, p);
    System.out.println("Added a user from the GET method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LoginService login = new LoginService();
    String u = request.getParameter("username");
    String e = request.getParameter("email");
    String p = request.getParameter("password");
    PrintWriter out = response.getWriter();
    
    Boolean unique = login.uniqueUser(e);
    if(unique) { 
      login.registerUser(u, e, p);
      out.write("Hi "+u);
    } else {
      out.write("Sorry, that email is already being used. Try again.");
    }
	}

}

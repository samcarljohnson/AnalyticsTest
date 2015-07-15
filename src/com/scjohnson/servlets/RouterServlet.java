package com.scjohnson.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.scjohnson.services.CategoryDAO;
import com.scjohnson.objects.SugarAccount;

/**
 * Servlet implementation class RouterServlet
 */

public class RouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RouterServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     
    public RouterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Inside doGet in Router.");
		String req = request.getParameter("id");
		CategoryDAO cat = new CategoryDAO();
		List<SugarAccount> result = new ArrayList<SugarAccount>();
		if(!req.isEmpty()) {
		  result = cat.getSP(req);
		}
	  PrintWriter out = response.getWriter();
	  response.setContentType("application/json");
	  response.setCharacterEncoding("UTF-8");
	  out.write(new Gson().toJson(result));
	  out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

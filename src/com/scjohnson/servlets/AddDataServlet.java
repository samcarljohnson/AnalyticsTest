package com.scjohnson.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scjohnson.services.AddDataService;
import com.scjohnson.services.LoginService;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class AddDataServlet
 */
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AddDataServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   log.info("Logger is working inside doGet!!!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  AddDataService data = new AddDataService();
    String a = request.getParameter("bubble_name");
    String b = request.getParameter("creator");
    String c = request.getParameter("bubble_num_moments");
    String d = request.getParameter("widget_nbu_views");
    String e = request.getParameter("total_video_views");
    String f = request.getParameter("visits");
    String g = request.getParameter("views_per_visit");
    String h = request.getParameter("average_watch_time");
    String i = request.getParameter("percentage_mobile");
    
    String[] sArr = {c,d,e,f,g,h,i};
    int[] iArr = new int[7];
    for(int count=0; count < sArr.length; count++) {
      iArr[count] = Integer.parseInt(sArr[count]);  
    }

    PrintWriter out = response.getWriter();
    
    Boolean unique = data.uniqueStr(a);
    if(unique) { 
      data.addData(a,b,iArr[0],iArr[1],iArr[2],iArr[3],iArr[4],iArr[5],iArr[6]);
      out.write("Bubble \""+a+"\" was added to the database.");
    } else {
      out.write("Sorry, a bubble with that name already exists. Choose another name.");
    }
	}

}

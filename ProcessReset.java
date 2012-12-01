package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class ProcessReset extends HttpServlet {
private String login="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp";

public void doGet(HttpServletRequest request, HttpServletResponse res)
throws ServletException, IOException  {

 	HttpSession session = request.getSession();
	session.invalidate(); //(I thought about invalidating all sessions, but did not want to mess with the other webapps in the context)
	
	getServletContext().setAttribute("jdresselAssertionSet",null);//Remove assertions
	
	
	String destination = request.getHeader("referer")==null ? login : request.getHeader("referer");
	res.sendRedirect(res.encodeRedirectURL(destination));
 
 }


}

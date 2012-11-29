package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class Restart extends HttpServlet {

private String username;
public void doGet(HttpServletRequest request, HttpServletResponse res)
throws ServletException, IOException  {
 	Singleton.reset();
	/*
	* Send the user back to where they belong
	*/
 
	String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp";
	res.sendRedirect(res.encodeRedirectURL(destination));
 
 }
public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	Singleton.reset();
	String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp";
	res.sendRedirect(res.encodeRedirectURL(destination));
}
}

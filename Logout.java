package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class Logout extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse res)
throws ServletException, IOException  {
	HttpSession session = request.getSession();
	session.invalidate(); 

	/*
	* Send the user back to where they belong
	*/
 
	String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp";
	res.sendRedirect(res.encodeRedirectURL(destination));
 
 }

}

package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class ProcessLogin extends HttpServlet {

private String username;
public void doGet(HttpServletRequest request, HttpServletResponse res)
throws ServletException, IOException  {
 
	/*
	* Send the user back to where they belong
	*/
 
	String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp";
	res.sendRedirect(res.encodeRedirectURL(destination));
 
 }
public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	username = request.getParameter("username")==null ? "" : request.getParameter("username");
	res.setContentType ("text/html");
	PrintWriter out = res.getWriter();
	out.println(username);
	HttpSession session = request.getSession();//If a session does not exist, this will start one
	User user = new User(username);
	session.setAttribute("username",user);
        out.close ();
}

}

package jdressel.Derporia64;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ProcessLogin extends HttpServlet {
 
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException  {
 
/*
* Send the user back to where they belong
*/
 
String destination  ="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp";        
response.sendRedirect(response.encodeRedirectURL(destination));
 
 }
}

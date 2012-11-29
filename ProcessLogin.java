package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class ProcessLogin extends HttpServlet {
 
public void doGet(HttpServletRequest request, HttpServletResponse res)
throws ServletException, IOException  {
 
/*
* Send the user back to where they belong
*/
 
String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp";        
res.sendRedirect(response.encodeRedirectURL(destination));
 
 }


}

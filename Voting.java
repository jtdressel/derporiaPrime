package jdressel.Derporia64;
// James Dressel and James Robertson
// Based on the Hello.java example
// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

// Import Java Libraries
import java.io.*;
import java.util.*;


public class Voting extends HttpServlet {
 
private final String styleSheet = "";

public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType ("text/html");
	PrintWriter out = res.getWriter ();
	out.println(Singleton.getAssertions().size());
	out.println("session");
	HttpSession session = request.getSession();
	out.println("User Name: "+session.getAttribute("username"));
	out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("starting");
out.println("<br>");
	Iterator iterator = Singleton.getAssertions().iterator();
	for (Iterator<Assertion> ass = Singleton.getAssertions().iterator(); ass.hasNext();){
			out.println("<br> loop");
			out.println(ass.next());
		}

	out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp\"> home</a>");
        out.close();
    }
}

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
	HttpSession session = request.getSession();
	
	
	Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
	if(d==null){

	} else {
Set<Assertion> assertions = (Set<Assertion>)d;

	for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
		out.println(assertionIterator.next());
		out.println("<br>");
	}
	}

	

	out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp\"> home</a>");
        out.close();
    }
}

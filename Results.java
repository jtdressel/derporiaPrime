package jdressel.Derporia64;
// James Dressel and James Robertson
// Based on the Hello.java example
// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

// Import Java Libraries
import java.io.*;


public class Results extends HttpServlet {

private String claim;
private String assertions;
private int disagree = 0;
private int unsure = 0;
private int convinced = 0;
private boolean showCount = false;//by default don't show the vote count. 
private final String styleSheet = "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://mason.gmu.edu/~jrobertq/derporia/derporiaStyle.css\">";

public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	showCount = true;
	setCount(request);
	setClaimAssertion(request);

	res.setContentType ("text/html");
	PrintWriter out = res.getWriter ();
	outputPage(out);
        out.close ();
    }

public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	showCount = false;
	setCount(request);
	setClaimAssertion(request);

	res.setContentType ("text/html");
	PrintWriter out = res.getWriter ();
	outputPage(out);
        out.close ();
}
	public void outputPage(PrintWriter out) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.println("<meta charset=\"UTF-8\">");
		out.println(styleSheet);
		out.println("<title>" + claim + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Derporia: the never-ending land of <del>baseless</del> claims</h1>");
		out.println("<hr>");
		out.println("	<br>");
		out.println("	<h1>James Robertson and James Dressel</h1>");
		out.println("<p>");
		out.println("The claim: ");
		out.println("<br>");
		out.println("<b><font color=\"#5F04B4\">"+ claim +"</font></b>");
		out.println("<br><br>");
		out.println("Evidence:");
		out.println("<br>");
		out.println("<b><font color=\"#5F04B4\">" + assertions + "</font></b>");
		out.println("</p>");
		out.println("<br>");
		out.println("<table class=\"center\" border=\"1\">");
		out.println("<tbody><tr>");
		out.println("<td>");
		out.println("<table width=\"100%\">");
		out.println("<tbody><tr>");
		out.println("<td align=\"left\">");
	out.println("<button onclick=\"location.href='http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Results?claim=" + claim + "&assertions="+ assertions +"&disagree="+(disagree+1)+"&unsure="+unsure+"&convinced="+convinced+"'\" type=\"button\" name=\"disagree\">Disagree</button>");
		out.println("</td>");
		out.println("<td align=\"center\">");
		out.println("<button onclick=\"location.href='http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Results?claim=" + claim + "&assertions="+ assertions +"&disagree="+disagree+"&unsure="+(unsure+1)+"&convinced="+convinced+"'\" type=\"button\" name=\"unsure\">Unsure</button>");
		out.println("<br>");
		//out.println("Unsure: " + unsure");
		out.println("</td>");
		out.println("<td align=\"right\">");
	out.println("<button onclick=\"location.href='http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Results?claim=" + claim + "&assertions="+ assertions +"&disagree="+disagree+"&unsure="+unsure+"&convinced="+(convinced+1)+"'\" type=\"button\" name=\"convinced\">Convinced</button>");
		out.println("</td>");
		out.println("</tr>");
		
		if(showCount){
			printCounter(out);
		}
		out.println("</tbody></table>");
		out.println("<p>");
		out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia.jsp\">Submit a new claim</a>");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
	}

	private void printCounter(PrintWriter out){
		out.println("<td>");
		out.println("Disagree: "+disagree);
		out.println("</td>");
		out.println("<td>");
		out.println("Unsure: " + unsure);
		out.println("</td>");
		out.println("<td>");
		out.println("Convinced: " + convinced);
		out.println("</td>");
		out.println("</td>");
		out.println("</tbody></table>");
		out.println("</td>");
		out.println("</tr>");
	}
	private void setCount(HttpServletRequest request){
	try{
		disagree = Integer.parseInt(request.getParameter("disagree"));

	}catch (Exception e) {
		disagree = 0;//if error set to zero 
	}

	try{
		unsure = Integer.parseInt(request.getParameter("unsure"));

	}catch (Exception e) {
		unsure = 0;//if error set to zero 
	}

	try{
		convinced = Integer.parseInt(request.getParameter("convinced"));

	}catch (Exception e) {
		convinced = 0;
	}
	}
	private void setClaimAssertion(HttpServletRequest request){
		claim = request.getParameter("claim")==null ? "" : request.getParameter("claim");
		assertions = request.getParameter("assertions")==null ? "" : request.getParameter("assertions");
	}

}

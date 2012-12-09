package jdressel.DerporiaPrime;

// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

// Import Java Libraries
import java.io.*;
import java.util.*;

/**
 * Servlet implementation class Voting
 */
public class Voting extends HttpServlet {
	private HttpServletRequest request;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voting() {
        super();


        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        this.request = request;	
    	printTop(response);
    	
    	try {
			printBody(request, response);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	printBottom(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public void printTop(HttpServletResponse res) throws IOException{
		res.setContentType ("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta http-equiv=\"content-type\" content=\"text/html\"; charset=\"UTF-8\">");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title><a href=\"Derporia.jsp\">Derporia</a>: the never-ending land of claimDEFWFWWEFs</title>");

		out.println("<!-- A project by James Dressel and James Robertson -->");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"votingStyle.css\" />");

		out.println("<script src=\"votingStyle.js\" /> </script>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1><a href=\"Derporia.jsp\">Derporia</a>: the never-ending land of <del>baseless</del> claims</h1>");

		Object derp  = request.getSession().getAttribute("username")==null ? "" : request.getSession().getAttribute("username");
		out.println(Utility.loginHeaderBanner(derp));
		request.getSession().setAttribute("loginRequester","Voting");
		

	}
	
	@SuppressWarnings("unchecked")
	public void printBody(HttpServletRequest request, HttpServletResponse res) throws IOException, SAXException, ParserConfigurationException{
		res.setContentType ("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = request.getSession();
		
		Utility.load(this.getServletContext());
		
		Object d = getServletContext().getAttribute("jdresselAssertionSet");
		@SuppressWarnings("unchecked")
		Set<Assertion> assertions = (Set<Assertion>)d;
		
		if(assertions.isEmpty()){
			out.println("<p>There are currently no claims :(</p>");
		} else {
			ArrayList<Assertion> sorted = new ArrayList<Assertion>(assertions);
    		Collections.sort(sorted);

			out.println("							<table class=\"mega\">");

			for(Assertion assertion: sorted){
				
				out.println("								<tr>");
				out.println("									<td class=\"mega\">");
				out.println("											<table class=\"center\">");
				out.println("											<tbody>");
				out.println("												<tr>");
				out.println("													<td>");
				out.println("														<p>Post by "+assertion.getUN()+"</p>");
				out.println("													</td>");
				out.println("												</tr>");
				out.println("												<tr>");
				String username = (session.getAttribute("username") == null)?"":session.getAttribute("username").toString(); 
				User user = new User(username);
/*				if(username.equals(assertion.getUN())){
					if(user.getConvinced().contains(assertion))
						out.println("													<td class=\"green\">");
					if(user.getUnsure().contains(assertion))
						out.println("													<td class=\"yellow\">");
					if(user.getDisagree().contains(assertion))
						out.println("													<td class=\"red\">");
				}
				else*/
					out.println("													<td>");
				out.println("													<p class=\"center\"><b>Claim: <br />"+assertion.getName()+"</b></p>");
				out.println("													<p class=\"center\"><i>Assertions: <br />"+assertion.getBody()+"</i></p>");
				out.println("													<p>Convinced: "+assertion.getConvinced()+"<br>");
				out.println("														Unsure:    "+assertion.getUnsure()+"<br>");
				out.println("														Disagree:  "+assertion.getDisagree()+"</p>");
				out.println("													</td>");
				out.println("												</tr>");
				out.println("											</tbody>");
				out.println("											</table>		");
				out.println("											<table class=\"center\">");
				out.println("											<tbody><tr>");
				out.println("												<td>");
				out.println("												<table width=\"100%\">");
				out.println("													<tbody><tr>");
				out.println("													<td align=\"left\">");
				out.println("<a class=\"red\" href=\"ProcessVote?vote=disagree&id=" + assertion.getId() +" \">Disagree</a>");
				
																
				out.println("													</td>");
				out.println("													<td align=\"center\">");
				out.println("<a class=\"yellow\" href=\"ProcessVote?vote=unsure&id=" + assertion.getId() +" \">Unsure</a>");
				
				out.println("													</td>");
				out.println("													<td align=\"right\">");
				out.println("<a class=\"green\" href=\"ProcessVote?vote=convinced&id=" + assertion.getId() +" \">Convinced</a>");
				
				out.println("													</td>");
				out.println("													</tr>");
				out.println("												</tbody></table>");
				out.println("												</td>");
				out.println("											</tr>");
				out.println("											</tbody>");
				out.println("											</table>");
				out.println("									</td>");
				out.println("								</tr>");
				}
				out.println("							</table>");
		}
			
	}
		
	public void printBottom(HttpServletResponse res) throws IOException{
		res.setContentType ("text/html");
		PrintWriter out = res.getWriter();
		out.println("<a class=\"button\" href=\"Derporia.jsp\" class=\"center\"> Make a Claim!</a>");
		out.println("							<h4>By James Robertson and James Dressel Homework 10</h4>");
		out.println("							</body>");
		out.println("							</html>");
		
		out.close();
	}
	
	public void destroy()
	{
		try {
			Utility.saveAssertions((Set<Assertion>) this.getServletContext().getAttribute("jdresselAssertionSet"));
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Utility.saveUsers((Map<String, User>) this.getServletContext().getAttribute("jdresselUserMap"));
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}
}

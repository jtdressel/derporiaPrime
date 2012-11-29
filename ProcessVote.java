package jdressel.Derporia64;
//James Dressel and James Robertson
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Iterator;
import java.util.*;


public class ProcessVote extends HttpServlet {

private String vote;

private Assertion underVote;
private String username;
private String id;
public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException  {
 
	/*
	* Send the user back to where they belong
	*/
 
	//String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Voting";
	//res.sendRedirect(res.encodeRedirectURL(destination));
 	HttpSession session = request.getSession();
	setVariables(request);
	if(session.getAttribute("username")==null){
		res.sendRedirect(res.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp"));//ERROR, send the user back
	} else {

		//TODO check for empty
		


		//Check if it is the users assertion
		//check if

		Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
		if(d==null){
			//TODO
		} else {
		Set<Assertion> assertions = (Set<Assertion>)d;
			
	

		for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
			Assertion assertion = assertionIterator.next();
			
			if(assertion.getId().equals(id)){
				
				underVote = assertion;
				//User test = new User("derp");
		
	//			underVote.voteConvinced(test);//TODO

				if(vote.equals("convinced")){
					underVote.setConvinced(underVote.getConvinced()+1);
				assertions.add(underVote);
				}


				if(vote.equals("unsure")){
					underVote.setUnsure(underVote.getUnsure()+1);
				assertions.add(underVote);
				}


				if(vote.equals("disagree")){
					underVote.setDisagree(underVote.getDisagree()+1);
				assertions.add(underVote);
				}


				assertions.add(underVote);
				getServletContext().setAttribute("jdresselAssertionSet",assertions);
				
			}
		
		}

		res.sendRedirect(res.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Voting"));
	}

	


}
 }

public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = request.getSession();
	setVariables(request);
	if(session.getAttribute("username")==null){
		res.sendRedirect(res.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Login.jsp"));//ERROR, send the user back
	} else {

		//TODO check for empty
		


		//Check if it is the users assertion
		//check if

		Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
		if(d==null){
			//TODO
		} else {
		Set<Assertion> assertions = (Set<Assertion>)d;
			PrintWriter out = res.getWriter ();
	
		out.println("stuff");
		for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
			Assertion assertion = assertionIterator.next();
			out.println(assertion);
			if(assertion.getId().equals(id)){
				out.println(assertion.getId());
				underVote = assertion;
				underVote.voteConvinced(new User(username));
				//underVote.setConvinced(underVote.getConvinced()+1);
				assertions.add(underVote);
				getServletContext().setAttribute("jdresselAssertionSet",assertions);
				
			}
		
		}

		out.close();
		//res.sendRedirect(res.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Voting"));
	}

	


}}

private void setVariables(HttpServletRequest request){
		vote = request.getParameter("vote")==null ? "" : request.getParameter("vote");
		id = request.getParameter("id")==null ? "" : request.getParameter("id");
	}


}

package jdressel.DerporiaPrime;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class ProcessVote
 */
public class ProcessVote extends HttpServlet {

private String vote;

private Assertion underVote;
private String id;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException  {
    	 
    	/*
    	* Send the user back to where they belVotingong
    	*/
     
    	//String destination="http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Voting";
    	//res.sendRedirect(res.encodeRedirectURL(destination));
     	HttpSession session = request.getSession();
    	setVariables(request);
    	if(session.getAttribute("username")==null){
    		res.sendRedirect(res.encodeRedirectURL("Login.jsp"));
    	} else {
    		User derp = new User("derp");
    		try {
				Utility.load(this.getServletContext());
			} catch (SAXException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		Object d = getServletContext().getAttribute("jdresselAssertionSet");

    		@SuppressWarnings("unchecked")
			Set<Assertion> assertions = (Set<Assertion>)d;
    			
    	

    		for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
    			Assertion assertion = assertionIterator.next();
    			
    			if(assertion.getId().equals(id)){
    				
    				underVote = assertion;
    	
    				if(underVote.getUN().equals(((User) session.getAttribute("username")).getUN())||(User) session.getAttribute("username")==null){
    					//out.println("same");
    					//out.println("<p class=/"error/">You cannot vote on your own post!<p>");
    					//res.sendRedirect(res.encodeRedirectURL("http://reddit.com"));
    				}
    				else if(vote.equals("convinced")){
    					
    						underVote.voteConvinced((User)session.getAttribute("username"));
    						assertions.add(underVote);
    						derp.voteConvinced(underVote);
    				}


    				else if(vote.equals("unsure")){
    				underVote.voteUnsure(derp);
    						assertions.add(underVote);
    						derp.voteUnsure(underVote);
    					
    				}


    				else if(vote.equals("disagree")){
    					
    						underVote.voteDisagree((User)session.getAttribute("username"));
    						assertions.add(underVote);
    						((User) session.getAttribute("username")).voteDisagree(underVote);
    					
    				}


    				assertions.add(underVote);
    				//getServletContext().setAttribute("jdresselAssertionSet",assertions);
    				res.sendRedirect(res.encodeRedirectURL("Voting.jsp"));
    			}
    		
    		}

    		
    	}

    	


    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));
	}
	private void setVariables(HttpServletRequest request){
		vote = request.getParameter("vote")==null ? "" : request.getParameter("vote");
		id = request.getParameter("id")==null ? "" : request.getParameter("id");
	}
	@Override
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

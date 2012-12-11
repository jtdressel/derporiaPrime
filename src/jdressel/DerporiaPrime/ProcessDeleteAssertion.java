package jdressel.DerporiaPrime;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class ProcessDeleteAssertion
 */
public class ProcessDeleteAssertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessDeleteAssertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id")==null ? "" : request.getParameter("id");
		Object d = getServletContext().getAttribute("jdresselAssertionSet");
		try{
			Set assertions = (Set) d;
			Assertion underVote = null;

    		for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
    			Assertion assertion = assertionIterator.next();
    			
    			if(assertion.getId().equals(id)){
    				
    				underVote = assertion;
    				assertions.remove(underVote);
    				getServletContext().setAttribute("jdresselAssertionSet", assertions);
    				try {
    					Utility.saveAssertions((Set<Assertion>) this.getServletContext().getAttribute("jdresselAssertionSet"));
    				} catch (ParserConfigurationException | TransformerException
    						| SAXException | IOException e) {
    					e.printStackTrace();
    				}
    				
    				try {
    					Utility.saveUsers((Map<String, User>) this.getServletContext().getAttribute("jdresselUserMap"));
    				} catch (ParserConfigurationException | TransformerException
    						| SAXException | IOException e) {
    					e.printStackTrace();
    				}

    				response.sendRedirect(response.encodeRedirectURL("Voting.jsp"));
    			}
    		
    		}
		}
		catch (Exception e){
			response.sendRedirect(response.encodeRedirectURL("Voting.jsp"));
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("Voting.jsp"));
	}
	public void destroy()
	{
		try {
			Utility.saveAssertions((Set<Assertion>) this.getServletContext().getAttribute("jdresselAssertionSet"));
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			Utility.saveUsers((Map<String, User>) this.getServletContext().getAttribute("jdresselUserMap"));
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException e) {
			e.printStackTrace();
		}
		super.destroy();
	}
}

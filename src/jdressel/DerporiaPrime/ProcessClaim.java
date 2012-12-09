package jdressel.DerporiaPrime;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


/**
 * Servlet implementation class ProcessClaim
 */
public class ProcessClaim extends HttpServlet {
	private String claim;
	private String assertions;
	private String username;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClaim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Send them somewhere smart
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		setClaimAssertion(request);
		if(session.getAttribute("username")==null){
			response.sendRedirect(response.encodeRedirectURL("Login.jsp"));//TODO//ERROR, send the user back
		} else {
			Assertion a = new Assertion(session.getAttribute("username").toString(), claim, assertions);
			if(getServletContext().getAttribute("jdresselAssertionSet")==null){
				Set<Assertion> assertions = new HashSet<Assertion>();
				getServletContext().setAttribute("jdresselAssertionSet",assertions);
			} 
			Object d = getServletContext().getAttribute("jdresselAssertionSet");
			Set<Assertion> setOfAssets;
			try{
				setOfAssets = (Set<Assertion>)d;
			}catch(ClassCastException e){
				setOfAssets = new HashSet<Assertion>();
			}
			
			setOfAssets.add(a);
			getServletContext().setAttribute("jdresselAssertionSet",setOfAssets);
			response.sendRedirect(response.encodeRedirectURL("Voting.jsp"));//TODO
		}
	}
	private void setClaimAssertion(HttpServletRequest request){
		claim = request.getParameter("claim")==null ? "" : request.getParameter("claim");
		assertions = request.getParameter("assertions")==null ? "" : request.getParameter("assertions");
	}
}

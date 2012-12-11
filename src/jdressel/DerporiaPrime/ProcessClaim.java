package jdressel.DerporiaPrime;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

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

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Derporia.jsp"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		setClaimAssertion(request);
		
		try {
			Utility.load(this.getServletContext());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(session.getAttribute("username")==null){
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Login.jsp"));//ERROR, send the user back
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
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Voting.jsp"));
		}
	}
	private void setClaimAssertion(HttpServletRequest request){
		claim = request.getParameter("claim")==null ? "" : request.getParameter("claim");
		assertions = request.getParameter("assertions")==null ? "" : request.getParameter("assertions");
	}
	
	@Override
	public void destroy()
	{
		try {
			Utility.saveAssertions((Set<Assertion>) this.getServletContext().getAttribute("jdresselAssertionSet"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Utility.saveUsers((Map<String, User>) this.getServletContext().getAttribute("jdresselUserMap"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.destroy();
	}
}
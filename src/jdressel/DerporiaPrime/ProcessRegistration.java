package jdressel.DerporiaPrime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessRegistration
 */
public class ProcessRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Sends the user to the homepage.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));//TODO//ERROR, send the user back
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check username and password parameters
		//check to see if username is in use
		//create user
		//login as user
		String username = request.getParameter("username")==null ? "" : request.getParameter("username");//TODO: error page if null
		String password = request.getParameter("password")==null ? "" : request.getParameter("password");//TODO error page if null
		//Object d = getServletContext().getAttribute("jdresselAssertionSet");

		
		HttpSession session = request.getSession();//If a session does not exist, this will start one
		if(session.getAttribute("username")!=null){
		//user is already logged in
			response.sendRedirect(response.encodeRedirectURL("LoggedInAlready.jsp"));//TODO
		} else
		{
			User user = new User(username, password, getServletContext());
			session.setAttribute("username",user);
			session.removeAttribute("loginRequester");//TODO: determine if loginRequestion exists
			response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));
			
		}
		
		
		
	}

}

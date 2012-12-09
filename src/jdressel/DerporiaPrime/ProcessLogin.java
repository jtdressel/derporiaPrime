package jdressel.DerporiaPrime;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Servlet implementation class ProcessLogin
 */
public class ProcessLogin extends HttpServlet {
	private String username;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		* Send the user back to where they belong
		*/
	 
		String destination="Derporia.jsp";//TODO
		response.sendRedirect(response.encodeRedirectURL(destination));//TODO
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username = request.getParameter("username")==null ? "" : request.getParameter("username");
		String password = request.getParameter("password")==null ? "" : request.getParameter("password");
		HttpSession session = request.getSession();//If a session does not exist, this will start one
		if(session.getAttribute("username")!=null){
		//user is already logged in
			response.sendRedirect(response.encodeRedirectURL("LoggedInAlready.jsp"));//TODO
		} else if(!userExists(new User(username))){
			response.sendRedirect(response.encodeRedirectURL("UserDoesNotExist.jsp"));//TODO
		}  else{
			User user = new User(username);
			
			if(passwordCorrect(user, password)){
				user = new User(username, password, getServletContext());
			} else {
				//TODO throw exception
				response.sendRedirect(response.encodeRedirectURL("WrongPassword.jsp"));
			}
			
			session.setAttribute("username",user);
			
			if(session.getAttribute("loginRequester")!=null){
			String toPage = (String)session.getAttribute("loginRequester");
			session.removeAttribute("loginRequester");
			response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));//TODO had problem here

			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getHeader("referer")));
			}
		
		}


	}
	
	private boolean userExists(User user){
		Set<User> userSet = User.getUserSet(getServletContext());
		if(userSet.contains(user)){
			return true;
		} else {
			return false;
		}
	}
	
	private boolean passwordCorrect(User user, String password){
		Set<User> userSet = User.getUserSet(getServletContext());
		User onServer = User.getUser(user.getUN(), userSet);
		
		if (onServer.passwordCorrect(password)){
			return true;
		}
		return false;
		
	}

}

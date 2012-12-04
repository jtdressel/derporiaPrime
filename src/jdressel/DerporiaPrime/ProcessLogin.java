package jdressel.DerporiaPrime;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


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
	 
		String destination="";//TODO
		response.sendRedirect(response.encodeRedirectURL(destination));//TODO
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username = request.getParameter("username")==null ? "" : request.getParameter("username");
		HttpSession session = request.getSession();//If a session does not exist, this will start one
		if(session.getAttribute("username")!=null){
		//user is already logged in
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/LoggedInAlready.jsp"));
		}else{
			User user = new User(username);
			session.setAttribute("username",user);

			//TODO: clean this up...
			
			if(session.getAttribute("loginRequester")!=null){
			String toPage = (String)session.getAttribute("loginRequester");
			session.removeAttribute("loginRequester");
			response.sendRedirect(response.encodeRedirectURL(toPage));

			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getHeader("referer")));
			}

		
		//once user is logged in, send them somewhere 
		
		}


	}

}

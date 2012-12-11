package jdressel.DerporiaPrime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

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
		response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Derporia.jsp"));
	}

	/**
	 * Processes a registration. If user or password is blank the user is directed to an error page. If the username is 
	 * already in use the user is directed to an error page. 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create user
		//login as user
		String username = request.getParameter("username")==null ? "" : request.getParameter("username");
		String password = request.getParameter("password")==null ? "" : request.getParameter("password");
		HttpSession session = request.getSession();//If a session does not exist, this will start one
		ServletContext context = getServletContext();
		
		try {
			Utility.load(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(username.equals("")){
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/UsernameMustNotBeEmpty.jsp"));
		} else if (password.equals("")){
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/PasswordMustNotBeEmpty.jsp"));
		} else if(session.getAttribute("username")!=null){
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/LoggedInAlready.jsp"));
		} else if(getUserMap().containsKey(username)){
			response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/UserAlreadyExists.jsp"));
		} else
		{
			User user = new User(username, password);
			addUserToMap(user);
			
			session.setAttribute("username",user);
			if(session.getAttribute("loginRequester")!=null){
				String toPage = session.getAttribute("loginRequester").toString();
				session.removeAttribute("loginRequester");
				response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Derporia.jsp"));
			} else {
				response.sendRedirect(response.encodeRedirectURL("http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/DerporiaPrime/Derporia.jsp"));
			}	
		}
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, User> getUserMap(){
		ServletContext context = getServletContext();
		Map<String, User> userMap = new HashMap<String, User>();
		Object attribute = context.getAttribute("jdresselUserMap");
		if(attribute!=null){
			userMap = (Map<String, User>)attribute;
		}
		return userMap;
	}

	@SuppressWarnings("unchecked")
	public void addUserToMap(User user){
		ServletContext context = getServletContext();
		Map<String, User> userMap = new HashMap<String, User>();
		Object attribute = context.getAttribute("jdresselUserMap");
		if(attribute!=null){
			userMap = (Map<String, User>)attribute;
		}
		userMap.put(user.getUN(), user);
		context.setAttribute("jdresselUserMap", userMap);
	}
	
	public void destroy()
	{
		try {
			Utility.saveAssertions((Set<Assertion>) this.getServletContext().getAttribute("jdresselAssertionSet"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Utility.saveUsers((Map<String, User>) this.getServletContext().getAttribute("jdresselUserMap"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}
}

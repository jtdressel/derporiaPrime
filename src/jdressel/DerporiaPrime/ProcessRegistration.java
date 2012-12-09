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
		response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));//TODO//ERROR, send the user back
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
		String username = request.getParameter("username")==null ? "" : request.getParameter("username");//TODO: error page if null
		String password = request.getParameter("password")==null ? "" : request.getParameter("password");//TODO error page if null
		HttpSession session = request.getSession();//If a session does not exist, this will start one
		ServletContext context = getServletContext();
		
		try {
			Utility.load(context);
		} catch (SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(username.equals("")){
			response.sendRedirect(response.encodeRedirectURL("UsernameMustNotBeEmpty.jsp"));
		} else if (password.equals("")){
			response.sendRedirect(response.encodeRedirectURL("PasswordMustNotBeEmpty.jsp"));
		} else if(session.getAttribute("username")!=null){
			response.sendRedirect(response.encodeRedirectURL("LoggedInAlready.jsp"));//TODO
		} else if(getUserMap().containsKey(username)){
			response.sendRedirect(response.encodeRedirectURL("UserAlreadyExists.jsp"));
			//TODO check to see if the user exists
		} else
		{
			User user = new User(username, password);
			addUserToMap(user);
			//TODO add user to the map jdresselUserSet
			session.setAttribute("username",user);
			if(session.getAttribute("loginRequester")!=null){
				String toPage = session.getAttribute("loginRequester").toString();
				session.removeAttribute("loginRequester");
				response.sendRedirect(response.encodeRedirectURL(toPage));
			} else {
				response.sendRedirect(response.encodeRedirectURL("Derporia.jsp"));
			}	
		}
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, User> getUserMap(){
		ServletContext context = getServletContext();
		Map<String, User> userMap = new HashMap<String, User>();
		Object attribute = context.getAttribute("jdresselUserMap");
		if(attribute!=null){
			//TODO check to see if this is correct class
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
			//TODO check to see if this is correct class
			userMap = (Map<String, User>)attribute;
		}
		userMap.put(user.getUN(), user);
		context.setAttribute("jdresselUserMap", userMap);
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

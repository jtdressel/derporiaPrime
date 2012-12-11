package jdressel.DerporiaPrime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class ProcessLogout
 */
public class ProcessLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		HttpSession session = request.getSession();
		session.invalidate();
		String destination = (request.getHeader("referer")!= null ? request.getHeader("referer") : null);
		response.sendRedirect(response.encodeRedirectURL(request.getHeader("referer")));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

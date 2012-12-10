package jdressel.DerporiaPrime;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utility {

	public static String loginHeaderBanner(Object userObject){
		String username = "";
		//Determine user
		try{
			User user = (User) userObject;
			username = user.getUN();
		} catch (ClassCastException e){
			//Assume logged out if exception occurs
			username = "";
		}
		if (username==""||username==null){
			return("<div class=\"username\">\n<form name=\"loginForm\"  action=\"ProcessLogin\" method=\"post\">\nLog In: <input type=\"text\" name=\"username\" placeholder=\"Username\" onkeypress=\"checkEnter(event)\">\n	<input class=\"regular\" type=\"submit\" value=\"Login\" name=\"Log In\"/>\n</form></div>");
		} 

		return("<div class=\"username\">You are logged in as "+username+" <a href=ProcessLogout> Logout</a></div>");
	}
	
	public static String getUsername(Object userObject){
		String username = "";
		//Determine user
		try{
			User user = (User) userObject;
			username = user.getUN();
		} catch (ClassCastException e){
			//Assume logged out if exception occurs
			username = "";
		}
		return username;
	}
	
	public static String getUsername(HttpSession session){
		//Object derp  = request.getSession().getAttribute("username")==null ? "" : request.getSession().getAttribute("username");
		//out.println(Utility.loginHeaderBanner(derp));
		Object userAttribute = session.getAttribute("username");
		String username = "";
		try{
			User user = (User) userAttribute;
			username = user.getUN();
		} catch (ClassCastException e){
			username = "";//TODO raise exception if user does not exist
		} catch (NullPointerException e){
			username = "";
		}

		return username;
	}
	
	public static Boolean isLoggedIn(HttpSession session){
		if(getUsername(session).equals(""))
			return false;
		return true;
	}
	
	public static void load(ServletContext context) throws SAXException, IOException, ParserConfigurationException{
		
		if(context.getAttribute("jdresselUserMap")!=null&&context.getAttribute("jdresselAssertionSet")!=null)
			return;
			
		
		File userFile = new File("users.xml");
		File assertionFile = new File("assertions.xml");
		HashMap<String, User> userMap = new HashMap<String, User>();
		Set<Assertion> assertionSet = new HashSet<Assertion>();
		
		if(assertionFile.exists()){
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(assertionFile);
			doc.getDocumentElement().normalize();

			NodeList assertionList = doc.getElementsByTagName("assertion");
 
			for (int i=0; i<assertionList.getLength(); i++) {
	 
			  Node assertion = assertionList.item(i);
		      Element e = (Element)assertion;
		      Assertion a = new Assertion(e.getAttribute("username"), e.getAttribute("title"), e.getAttribute("body"));
		      assertionSet.add(a);
		      
			}
		}
		
		if(userFile.exists()){
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(userFile);
			doc.getDocumentElement().normalize();

			NodeList userList = doc.getElementsByTagName("user");
 
			for (int i=0; i<userList.getLength(); i++) {
	 
			  Node user = userList.item(i);
		      Element e = (Element)user;
		      User u = new User(e.getAttribute("name"), e.getAttribute("password"));
		      
		      NodeList userTags = user.getChildNodes();
		      
		      for (int j=0; j<userList.getLength(); j++) {
		    	  if(userTags.item(j).getNodeName().equals("disagree")){
		    		  for(Assertion a: assertionSet){
		    			  if(a.getId().equals(userTags.item(j)))
		    				  u.voteDisagree(a);
		    		  }
		    		  
		    	  }
		    	  if(userTags.item(j).getNodeName().equals("convinced")){
		    		  for(Assertion a: assertionSet){
		    			  if(a.getId().equals(userTags.item(j)))
		    				  u.voteConvinced(a);
		    		  }
		    		  
		    	  }
		    	  if(userTags.item(j).getNodeName().equals("unsure")){
		    		  for(Assertion a: assertionSet){
		    			  if(a.getId().equals(userTags.item(j)))
		    				  u.voteUnsure(a);
		    		  }
		    		  
		    	  }

		      }
		      
		      userMap.put(u.getUN(), u);
			}
		}
		
		context.setAttribute("jdresselUserMap", userMap);
		context.setAttribute("jdresselAssertionSet", assertionSet);		
	}		
	
	public static void saveUsers(Map<String, User> userMap) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		File file = new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\users.xml");
		file.delete();

		File f = new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\users.xml");
		f.createNewFile();
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element users = doc.createElement("users");
		doc.appendChild(users);
		 
		// user elements
		for(Map.Entry<String, User> entry : userMap.entrySet()){
			Element user = doc.createElement("user");
			users.appendChild(user);
			 
			user.setAttribute("username", entry.getValue().getUN());
			user.setAttribute("password", "password");
			//TODO get password user.setAttribute("password", entry.getValue().getPassword());
			 
			// votedOn loop until set is done, same for disagree, convinced and unsure
			for(Assertion a: entry.getValue().getAssertions()){
				Element votedOn = doc.createElement("votedOn");
				votedOn.appendChild(doc.createTextNode(a.getId()));
				user.appendChild(votedOn);
			}
			
			for(Assertion a: entry.getValue().getDisagree()){
				Element disagree = doc.createElement("disagree");
				disagree.appendChild(doc.createTextNode(a.getId()));
				user.appendChild(disagree);
			}
			
			for(Assertion a: entry.getValue().getConvinced()){
				Element convinced = doc.createElement("convinced");
				convinced.appendChild(doc.createTextNode(a.getId()));
				user.appendChild(convinced);
			}
			
			for(Assertion a: entry.getValue().getUnsure()){
				Element unsure = doc.createElement("unsure");
				unsure.appendChild(doc.createTextNode(a.getId()));
				user.appendChild(unsure);
			}
		}
		
		 

		
		// write the content into xml file
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); //indent is automatically set to 0
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\users.xml"));
		
		transformer.transform(source, result);
		
		//new idea?
		//Transformer transformer = TransformerFactory.newInstance().newTransformer();
		//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	
		//StreamResult result = new StreamResult(new StringWriter());
		//DOMSource source = new DOMSource(doc);
		//transformer.transform(source, result);

		//String xmlOutput = result.getWriter().toString();
		//System.out.println(xmlOutput);
	}
	
	public static void saveAssertions(Set<Assertion> assertionSet)throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		File file = new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\assertions.xml");
		file.delete();
		
		File f = new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\assertions.xml");
		f.createNewFile();
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();;

		Element assertions = doc.createElement("assertions");
		doc.appendChild(assertions);
		 
		// assertion elements
		for(Assertion a: assertionSet){
			Element assertion = doc.createElement("assertion");
			assertions.appendChild(assertion);
			
			assertion.setAttribute("uuid",	a.getId());
			
			assertion.setAttribute("title", a.getName());
			
			assertion.setAttribute("body", a.getBody());
			
			assertion.setAttribute("username", a.getUN());
		}
		
		// write the content into xml file
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); //indent is automatically set to 0
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("H:\\Dropbox\\Eclipse Workspace\\derporiaPrime\\assertions.xml"));
		
		transformer.transform(source, result);
	}
	
}

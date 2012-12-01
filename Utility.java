package jdressel.Derporia64;

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
			return("<div class=\"username\">\n<form name=\"loginForm\"  action=\"http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessLogin\" method=\"post\">\nLog In: <input type=\"text\" name=\"username\" placeholder=\"Username\" onkeypress=\"checkEnter(event)\">\n	<input class=\"regular\" type=\"submit\" name=\"Log In\"/>\n</form></div>");
		} 

		return("<div class=\"username\">You are logged in as "+username+" <a href=http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.Logout> Logout</a></div>");
	}



	
}

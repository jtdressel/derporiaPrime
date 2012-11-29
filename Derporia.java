package jdressel.Derporia64;

import java.util.*;

public class Derporia 
{
	private static List<Assertion> assertions; 
	private static List<User> usernames;

	public static List<Assertion> getAssertions() {
		return assertions;
	}

	public static void setAssertions(List<Assertion> assertions) {
		this.assertions = assertions;
	}

	public static List<User> getUsernames() {
		return usernames;
	}

	public static void setUsernames(List<User> usernames) {
		this.usernames = usernames;
	}
	
	/** 	This method removes a from the list of assertions and from the User that generated the assertion
	 * 
	 * 		@author James Robertson
	 * 
	 * 		@param a the Assertion to be removed
	 * 		@return true if operation completed successfully
	 * 		@return false if the assertion could not be found
	 * 		@throws NullPointerExcpetion if a is null
	 */
	public static boolean removeAssertion(Assertion a){
		if(a==null)
			throw new NullPointerException();
		
		if(!assertions.contains(a))
			return false;
		assertions.remove(assertions.indexOf(a));
		
		User u = new User(a.getUN());
		u = usernames.get(usernames.indexOf(u));
		if(u.removeAssertion(a))
			return true;
		
		return false;
	}
	
	/** 	This method removes a User from usernames
	 * 
	 * 		@author James Robertson
	 * 
	 * 		@param u the User to be removed
	 * 		@return true if operation completed successfully
	 * 		@return false if the assertion could not be found
	 * 		@throws NullPointerExcpetion if a is null
	 */
	public static boolean removeUser(User u){
		if(u == null)
			throw new NullPointerException();
		
		if(!usernames.contains(u))
			return false;
		
		usernames.remove(usernames.indexOf(u));
		return true;
	}
}

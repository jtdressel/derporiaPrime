package jdressel.Derporia64;
import java.util.*;

/*	
 * 	This class contains assertions made by users
 * 	@author James Dressel
 */
public class Singleton {
	
	private static Set<Assertion> assertions = new HashSet<Assertion>();
	private static Set<User> users = new HashSet<User>();


	private Singleton(){
		throw new AssertionError();//From the bloch book. Keep from being constructed
	}
	
	public static Set<Assertion> getAssertions(){
		return assertions;
	}

	public static Set<User> getUsers(){
		return users;
	}

	public static void addAssertion(Assertion assertion){
		assertions.add(assertion);
	}

	public static void addUser(User user){
		users.add(user);
	}

	public static void removeAssertion(Assertion assertion){
		assertions.remove(assertion);
	}

	public static void removeUser(User user){
		users.remove(user);
	}
	
}

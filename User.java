package jdressel.Derporia64;
import java.util.*;

/*
 *	This class contains a user for Derporia
 *	@author James Robertson
 */
public class User {
	private final String UN;
	private List<Assertion> assertions;
	
	public User(String username){
		UN = username;
	}
	
	public String getUN(){
		return UN;
	}
	
	public List<Assertion> getAssertions(){
		return assertions;
	}
	
	/**		Removes a from the list of assertions
	 * 
	 * 		@author James Robertson
	 * 
	 * 		@param a the assertion to be removed
	 * 		@return true if the assertion was removed
	 * 		@return false if the assertion could not be found
	 * 		@throws NullPointerException if a is null
	 */
	
	public boolean removeAssertion(Assertion a){
		if(a == null)		
			throw new NullPointerException();
		if(!assertions.contains(a))
			return false;
		assertions.remove(assertions.indexOf(a));
		return true;
	}
	
	/**		Adds an assertion to the list of assertions made by this user
	 * 	
	 * 		@author James Robertson
	 * 		
	 * 		@param a the assertion to add
	 * 		@return True if assertion was added 
	 * 		@return False if the assertion already exists
	 * 		@throws NullPointerException if a is null
	 */
	public boolean makeAssertion(Assertion a){
		if(a==null)
			throw new NullPointerException("Assertion cannot be null");
		if(assertions.contains(a))
			return false;
		assertions.add(a);
		return true;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof User))
			return false;
		if(UN.equals(((User) o).getUN()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return UN.hashCode();
	}
	
	@Override
	public String toString()
	{
		return UN.toString();
	}
	
}

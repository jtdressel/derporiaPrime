package jdressel.DerporiaPrime;
import java.util.*;

import javax.servlet.ServletContext;

/**
 *	This class contains a user for Derporia
 *	@author James Robertson
 */
public class User {
	private final String UN;
	private String password;
	private List<Assertion> assertions;
	private List<Assertion> convinced;
	private List<Assertion> unsure;
	private List<Assertion> disagree;
	
	public User(String username){
		UN = username;
	}
	
	public User(String username, String password){
		UN = username;
		this.password = hashPassword(password);
	}
	
	public String getUN(){
		return UN;
	}
	
	public List<Assertion> getConvinced(){
		return convinced;
	}
	
	/**		Adds a to the list of assertions voted convinced for.  
	 *		If a has been voted on differently, removes a from the different list and adds to convinced.		
	 * 		@author James Robertson
	 * 
	 * 		@param a the assertion to be added to convinced
	 * 		@return true if the assertion was added
	 * 		@return false if the assertion is already in convinced
	 * 		@throws NullPointerException if a is null
	 */
	
	public boolean voteConvinced(Assertion a){
		return true;
	}
	
	public List<Assertion> getUnsure(){
		return unsure;
	}
	
	/**		Adds a to the list of assertions voted unsure for.  
	 *		If a has been voted on differently, removes a from the different list and adds to unsure.		
	 * 		@author James Robertson
	 * 
	 * 		@param a the assertion to be added to unsure
	 * 		@return true if the assertion was added
	 * 		@return false if the assertion is already in unsure
	 * 		@throws NullPointerException if a is null
	 */
	public boolean voteUnsure(Assertion a){
		return true;
	}
	
	public List<Assertion> getDisagree(){
		return disagree;
	}
	
	/**		Adds a to the list of assertions voted disagree for.  
	 *		If a has been voted on differently, removes a from the different list and adds to disagree.		
	 *		@author James Robertson
	 * 
	 * 		@param a the assertion to be added to disagree
	 * 		@return true if the assertion was added
	 * 		@return false if the assertion is already in disagree
	 * 		@throws NullPointerException if a is null
	 */
	public boolean voteDisagree(Assertion a){
		return true;
	}
	
	public List<Assertion> getAssertions(){
		return assertions;
	}
	
	/**		Removes a from the list of assertions
	 * 		@author James Robertson
	 * 
	 * 		@param a the assertion to be removed
	 * 		@return true if the assertion was removed
	 * 		@return false if the assertion could not be found
	 * 		@throws NullPointerException if a is null
	 */
	
	public boolean removeAssertion(Assertion a){
		if(a == null)		
			throw new NullPointerException("Assertion cannot be null");
		if(!assertions.contains(a))
			return false;
		assertions.remove(assertions.indexOf(a));
		return true;
	}
	
	/**		Adds an assertion to the list of assertions made by this user
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
	
	public static String hashPassword(String password){
		//TODO: Actually hash the password
		return password;
	}

	public boolean passwordCorrect(String password){
		if(this.password.equals(hashPassword(password)))
			return true;
		return false;
	}
	

	
	
}

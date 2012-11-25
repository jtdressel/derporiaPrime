package Derporia;
import java.util.*;

/*	
 * 	This class contains assertions made by users
 * 	@author James Robertson
 */
public class Assertion {
	private int convinced = 0;
	private int disagree = 0;
	private int unsure = 0;
	private final String UN;
	private String title;
	private String body;
	private List<User> voters;
	
		public Assertion(String username, String title, String body) {
		super();
		UN = username;
		this.title= title;
		this.body = body;
	}
		
	public String getName() {
		return title;
	}
	public void setName(String title) {
		this.title= title;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getUN() {
		return UN;
	}
	
	public int getConvinced() {
		return convinced;
	}
	
	public int getDisagree() {
		return disagree;
	}
	
	public int getUnsure() {
		return unsure;
	}
	
	/*	Increments convinced if u has not already voted on this Assertion
	 * 	@author James Robertson
	 * 
	 * 	@return True if the vote was added successfully
	 * 	@return False if the user has already voted on this Assertion
	 * 	@throws NullPointerException if u is null
	 */
	public boolean voteConvinced(User u){
		if(u==null)
			throw new NullPointerException("User cannot be null");
		if(voters.contains(u))
			return false;
		convinced++;
		return true;
	}
	
	/*	Increments disagree if u has not already voted on this Assertion
	 * 	@author James Robertson
	 * 
	 * 	@return True if the vote was added successfully
	 * 	@return False if the user has already voted on this Assertion
	 * 	@throws NullPointerException if u is null
	 */
	public boolean voteDisagree(User u){
		if(u==null)
			throw new NullPointerException("User cannot be null");
		if(voters.contains(u))
			return false;
		disagree++;
		return true;
	}

	/*	Increments unsure if u has not already voted on this Assertion
	 * 	@author James Robertson
	 * 
	 * 	@return True if the vote was added successfully
	 * 	@return False if the user has already voted on this Assertion
	 * 	@throws NullPointerException if u is null
	 */
	public boolean voteUnsure(User u){
		if(u==null)
			throw new NullPointerException("User cannot be null");
		if(voters.contains(u))
			return false;
		unsure++;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = prime * result + ((UN == null) ? 0 : UN.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assertion other = (Assertion) obj;
		if (UN == null) {
			if (other.UN != null)
				return false;
		} else if (!UN.equals(other.UN))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}

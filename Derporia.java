package Derporia;

import java.util.*;

public class Derporia 
{
	private List<Assertion> assertions; 
	private List<User> usernames;
	
	public Derporia(List<Assertion> assertions, List<User> usernames) {
		this.assertions = assertions;
		this.usernames = usernames;
	}

	public List<Assertion> getAssertions() {
		return assertions;
	}

	public void setAssertions(List<Assertion> assertions) {
		this.assertions = assertions;
	}

	public List<User> getUsernames() {
		return usernames;
	}

	public void setUsernames(List<User> usernames) {
		this.usernames = usernames;
	}
}

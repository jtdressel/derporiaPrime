package jdressel.Derporia64;
// James Dressel and James Robertson
// Based on the Hello.java example
// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

// Import Java Libraries
import java.io.*;
import java.util.*;


public class Voting extends HttpServlet {
 
private final String styleSheet = "";

public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType ("text/html");
	PrintWriter out = res.getWriter ();
	HttpSession session = request.getSession();
	
	
	Object d = getServletContext().getAttribute("jdresselAssertionSet");
	
	if(d==null){
		//TODO
	} else {
Set<Assertion> assertions = (Set<Assertion>)d;

	for(Iterator<Assertion> assertionIterator = assertions.iterator(); assertionIterator.hasNext();){
			<table class="center">
					<tbody>
						<tr>
							<td>
								<p class="center"><a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a> just posted:</p>
							</td>
						</tr>
						<tr>
							<td>
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							</td>
						</tr>
					</tbody>
	</table>		
	
	<h2>Check out some posts by other users!</h2>
	
	<!--END JUST SUBMITTED A CLAIM-->
	<table class="mega">
		<tr>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
							</td>
						</tr>
						<tr>
							<td> <!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 0<br>
								Unsure:    0<br>
								Disagree:  0</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
							</td>
						</tr>
						<tr>
							<td> <!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 0<br>
								Unsure:    0<br>
								Disagree:  0</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
							</td>
						</tr>
						<tr>
							<td> <!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 0<br>
								Unsure:    0<br>
								Disagree:  0</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
		</tr>
		<tr>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
							</td>
						</tr>
						<tr>
							<td class="red"> <!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 0<br>
								Unsure:    0<br>
								Disagree:  1</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
							</td>
						</tr>
						<tr>
							<td class="yellow"><!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 0<br>
								Unsure:    1<br>
								Disagree:  0</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
			<td class="mega">
					<table class="center">
					<tbody>
						<tr>
							<td>
								<p>Post by <a href="http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/username.html">UserName</a></p>
								
							</td>
						</tr>
						<tr>
							<td class="green"><!--TODO make this dynamic change class between colors depending on vote-->
							<p class="center"><b>Claim needs to go here</b></p>
							<p class="center"><i>Assertion needs to go here</i></p>
							<p>Convinced: 1<br>
								Unsure:    0<br>
								Disagree:  0</p>
							</td>
						</tr>
					</tbody>
					</table>		
					<table class="center">
					<tbody><tr>
						<td>
						<table width="100%">
							<tbody><tr>
							<td align="left">
								<button type="button" class="red" name="disagree">Disagree</button> 
							</td>
							<td align="center">
								<button type="button" class="yellow" name="unsure">Unsure</button> 
							</td>
							<td align="right">
								<button type="button" class="green" name="convinced">Convinced</button> 
							</td>
							</tr>
						</tbody></table>
						</td>
					</tr>
					</tbody>
					</table>
			</td>
		</tr>
	</table>
		
		Assertion assertion = assertionIterator.next();
		out.println(assertion);
		out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessVote?vote=convinced&id=" + assertion.getId() +" \">Convinced</a>");
		out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessVote?vote=disagree&id=" + assertion.getId() +" \">disagree</a>");
		out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/servlet/jdressel.Derporia64.ProcessVote?vote=unsure&id=" + assertion.getId() +" \">unsure</a>");
		out.println("<br>");
	}
	}

	

	out.println("<a href=\"http://apps-swe432.vse.gmu.edu:8080/swe432/jsp/jdressel/Derporia64/Derporia.jsp\"> home</a>");
        out.close();
    }
}

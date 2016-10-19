package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Withdraw extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false); // check session
		if (ses == null) 
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		    req.getRequestDispatcher("/login?token=1").forward(req,resp); // prompt user to login
			
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country"); // get user language mode
		Integer myId = (Integer)req.getSession(true).getAttribute("uid"); // get user ID
		
		if(myId!=null) //user must be logged in
		{
			
			String myToken=req.getParameter("token"); // get the token what to do
			
			if(myCountry.equals("DE"))
				
			{
				if(myToken.equals("1"))
				{
					 String myMsg="Da ist etwas schiefgegangen. Bitte versuchen Sie es erneut!";
					 req.setAttribute("msg", myMsg);
					 req.getRequestDispatcher("withdrawFormGr.jsp").forward(req,resp);
							
				}
				
				else if(myToken.equals("2"))
				{
					 //help
					String myMsg="Zurückzuziehen Betrag muss positiv sein";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawFormGr.jsp").forward(req,resp);
						
				}
				  
				 else if(myToken.equals("3"))
					 
				{
					MyModel withdrawAmount1= new MyModel();
		        	int myBalance=withdrawAmount1.knowBalance(myId); //help
					String myMsg=" Ihr Ergebnis lautet: " + myBalance+ ".Bitte hinterlegen Weitere ersten oder zurückzuziehen weniger als " +myBalance;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawFormGr.jsp").forward(req,resp);
						
				}
				else if(myToken.equals("4"))
				{
							String myMsg="Bitte füllen Sie alle Felder aus!";
							req.setAttribute("msg", myMsg);
							req.getRequestDispatcher("withdrawFormGr.jsp").forward(req,resp);
				}
				 
				else
				{
					String myMsg=null;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawFormGr.jsp").forward(req,resp);
				}
					
			}
			else
			{
				if(myToken.equals("1"))
				{
					String myMsg="Something went wrong.Please try again.";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawForm.jsp").forward(req,resp);
				}
				
				if(myToken.equals("2"))
				{
					String myMsg="Withdraw amount must be positive";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawForm.jsp").forward(req,resp);
				}
				 
				else if(myToken.equals("3"))
				{
					 	MyModel withdrawAmount1= new MyModel();
			        	int myBalance=withdrawAmount1.knowBalance(myId);
						String myMsg="Your balance is= " + myBalance+ ".Please deposit more first or withdraw less than" +myBalance;
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("withdrawForm.jsp").forward(req,resp);
				}
				 
				 else if(myToken.equals("4"))
				{
						String myMsg="Please fill up all fields.";
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("withdrawForm.jsp").forward(req,resp);
							
				}
				else
				{
					String myMsg=null;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("withdrawForm.jsp").forward(req,resp);
						
						
				}
			}
		}
		else
		{
			// user did not log in.prompt the user to login
			req.getRequestDispatcher("/login?token=1").forward(req,resp);
		}	
		
	}
		
	
}

package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DepositServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false);
		
		if (ses == null) {
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		    req.getRequestDispatcher("/login?token=1").forward(req,resp);  // no session exists, so tell user to login
			
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		Integer myId = (Integer)req.getSession(true).getAttribute("uid");  // get user ID
		
		if(myId!=null)  // if user ID exists that means if the user is in logged in state
			
		{
		
				String myToken=req.getParameter("token"); // get the idea what message should show
				
				if(myCountry.equals("DE"))
					
				{
					 if(myToken.equals("1"))
						{
							String myMsg="Da ist etwas schiefgegangen. Bitte versuchen Sie es erneut!";
							req.setAttribute("msg", myMsg);
							req.getRequestDispatcher("depositFormGr.jsp").forward(req,resp);
									
						}
					 
					 else  if(myToken.equals("2"))
					   {
						 //help
							String myMsg="Einzahlungsbetrag muss positiv sein";
							req.setAttribute("msg", myMsg);
							req.getRequestDispatcher("depositFormGr.jsp").forward(req,resp);
								
					   }
					 
					 else if(myToken.equals("3"))
						{
							 String myMsg="Alle Felder müssen ausgefüllt werden!";
							 req.setAttribute("msg", myMsg);
							 req.getRequestDispatcher("depositFormGr.jsp").forward(req,resp);
									
						}
					 else
					 	{
							String myMsg=null;
							req.setAttribute("msg", myMsg);
							req.getRequestDispatcher("depositFormGr.jsp").forward(req,resp);
					 	}
						
				}
				else
				{
					
					if(myToken.equals("1"))
					{
						String myMsg="Something went wrong.Please try again to deposit.";
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("depositForm.jsp").forward(req,resp);
					}
					
					else if(myToken.equals("2"))
					{
						String myMsg="Deposit amount must be positive";
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("depositForm.jsp").forward(req,resp);
					}
					
					else if(myToken.equals("3"))
						
					{
							String myMsg="Please fill up fields.";
							req.setAttribute("msg", myMsg);
							req.getRequestDispatcher("depositForm.jsp").forward(req,resp);
					}
					else  // default, no message
					{
						String myMsg=null;
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("depositForm.jsp").forward(req,resp);
							
					}
				}
				
			}
			else  // user id is null ,that means did not log in. so prompt the user to login first
			{
				req.getRequestDispatcher("/login?token=1").forward(req,resp);
			}		
		
	}
		
	
}

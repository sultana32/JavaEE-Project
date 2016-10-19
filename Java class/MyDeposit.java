package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@SuppressWarnings("serial")
public class MyDeposit extends HttpServlet
{
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession ses = request.getSession(false);  // check session
			if (ses == null) 
			{
			    // Not created yet. Now do so yourself.
			    ses = request.getSession();
			    ses.setAttribute("country", "eng");
			    request.getRequestDispatcher("/login?token=1").forward(request,response); // prompt user to login as no session exists
			} 
			
			String myCountry=(String)request.getSession(true).getAttribute("country");
			Integer myId = (Integer)request.getSession(true).getAttribute("uid");// get UserID
			
		    String quantity =request.getParameter("amount");  // get form data -amount
			if(quantity==null||quantity.equals(""))
			{
				// if any field is empty, prompt user to fill it up
				 request.getRequestDispatcher("/deposit?token=3").forward(request,response);
			}
			
		     int myQuantity=Integer.parseInt(quantity);
		     if( myQuantity>0)   // negative amount deposit not allowed
		     {
		        
		        
		        	MyModel depositAmount= new MyModel();
		        	int mySuccess=depositAmount.depositFunc(myId, "deposit", myQuantity);  // save the deposit transaction into Transaction table
		        	if(mySuccess==1)
		        	{
		        		// if transaction save is successful, then know the current balance of the user
		        		
		        		int myBalance=depositAmount.knowBalance(myId);
		        		request.setAttribute("balance", myBalance);
		        		
		        		// show user the balance after his transaction
		        		if(myCountry.equals("DE"))
		        		{
		        			request.getRequestDispatcher("afterDepositGr.jsp").forward(request,response);
		        		}
		        		else
		        		{
		        			request.getRequestDispatcher("afterDeposit.jsp").forward(request,response);
		        		}
		        	}
		        	else
		        	{
		        		// if there is problem in saving the transaction into dbs,then tell user that there has been some problem
		        		request.getRequestDispatcher("/deposit?token=1").forward(request,response);
		        	}
		     }
		     else
		     {
		    	 // tell the user that deposit amount should be positive
		    	 request.getRequestDispatcher("/deposit?token=2").forward(request,response);
		    	 
		    	 
		     }
		        	
		      
		}

}

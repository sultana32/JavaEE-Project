package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class MyWithdraw extends HttpServlet
{
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String myCountry=(String)request.getSession(true).getAttribute("country");  // user language mode
			Integer myId = (Integer)request.getSession(true).getAttribute("uid"); //user ID
			
			String quantity =request.getParameter("amount"); // get form data
			
			if(quantity==null||quantity.equals("")) // if any field is empty, prompt user to fill up
			{
				 request.getRequestDispatcher("/withdraw?token=4").forward(request,response);
			}
		     int myQuantity=Integer.parseInt(quantity);
		     
		     if( myQuantity>0)  // withdraw quantity must be positive
		     {
		        
		        
		        	MyModel withdrawAmount= new MyModel();
		        	int myBalance=withdrawAmount.knowBalance(myId);  // check current balance
		        	
		        	if(myBalance>myQuantity)  // current balance must be bigger that withdraw amount
		        	{
		        		myQuantity*=-1;     // withdraw amount saved in negative mood
		        		
		        		int mySuccess=withdrawAmount.withdrawFunc(myId, "withdraw", myQuantity);
			        	if(mySuccess==1) // if successfully saved
			        	{
			        		myBalance=withdrawAmount.knowBalance(myId);  // know balance after withdraw
			        		
			        		request.setAttribute("balance", myBalance);
			        		// say user the current balance 
			        		if(myCountry.equals("DE"))
			        		{
			        			request.getRequestDispatcher("afterWithdrawGr.jsp").forward(request,response);
			        		}
			        		
			        		else
			        		{
			        			request.getRequestDispatcher("afterWithdraw.jsp").forward(request,response);
			        		}
			        	}
			        	else
			        	{
			        		// some problem in transaction save, so tell the user 
			        		request.getRequestDispatcher("/withdraw?token=1").forward(request,response);
			        	}
		        	}
		        	else
		        	{
		        		// user tried to withdraw  more than his balance. say it to user
		        		 
		        		 request.getRequestDispatcher("/withdraw?token=3").forward(request,response);
		        	}
		        	
		     }
		     else
		     {
		    	 // user out a negative amount to withdraw
		    	 
		    	 request.getRequestDispatcher("/withdraw?token=2").forward(request,response);
		     }
		        	
		      
		}

}

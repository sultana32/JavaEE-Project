package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyTransfer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String myCountry = (String) request.getSession(false).getAttribute("country");
		Integer myId = (Integer)request.getSession(true).getAttribute("uid");
		String quantity = request.getParameter("amount");
		String acc = request.getParameter("account");
		// all field check
		 if(quantity==null||quantity.equals("")||acc==null||acc.equals(""))
			{
			 request.getRequestDispatcher("/transfer?token=6").forward(request,response);
			}
		int myQuantity = Integer.parseInt(quantity); // transfer amount
		
		int yourAcc = Integer.parseInt(acc);    // transfer to account
		MyModel transferAmount = new MyModel();
		int exist = transferAmount.userExist(yourAcc); // check if the provided transfer id exists
		if(myId==yourAcc)   // check if transfer id is same with self id. 
		{
			request.getRequestDispatcher("/transfer?token=5").forward(request, response);
		}
		if (exist==1) // if transfer id exists
		{
			if (myQuantity > 0) // if transfer amount positive
			{

				int myBalance = transferAmount.knowBalance(myId);  // know user balance
				
				if (myBalance > myQuantity) // user balance must be greater than transfer amount
				{
					String type2 = "Transfer from" + " " + myId.toString();
					int mySuccess2 = transferAmount.depositFunc(yourAcc, type2, myQuantity); // save the amount as deposit in transfer account
					myQuantity *= -1;
					String type1 = "Transfer to" + " " + acc;

					int mySuccess1 = transferAmount.withdrawFunc(myId, type1, myQuantity);// save the amount as withdraw in user account
					if (mySuccess1 == 1 && mySuccess2 == 1)  // if both save successfull
					{
						int newBalance = transferAmount.knowBalance(myId); // know new user balance
						request.setAttribute("balance", newBalance);
						// show the user current balance
						if (myCountry.equals("DE")) 
						{
							request.getRequestDispatcher("afterTransferGr.jsp").forward(request, response);
						} 
						else
						{
							request.getRequestDispatcher("afterTransfer.jsp").forward(request, response);
						}
					} 
					else
					{ // something wrong happened in dbs saving
						request.getRequestDispatcher("/transfer?token=1").forward(request, response);
					}
				} 
				else 
				{
					// user tried to transfer more than his balance
					request.getRequestDispatcher("/transfer?token=3").forward(request, response);
				}

			} 
			else // user provided negative transfer amount
			{
				request.getRequestDispatcher("/transfer?token=2").forward(request, response);
			}
		} 
		else // user provided a non exist account as transfer id
		{
			request.getRequestDispatcher("/transfer?token=4").forward(request, response);
		}

	}

}

package hasan.com.rashid;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;





@SuppressWarnings("serial")
public class Balance extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession ses = req.getSession(false); // check if session is already created
		if (ses == null)
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");  // and set default session mode as English
		    req.getRequestDispatcher("/login?token=1").forward(req,resp); // prompt the user to login.
			
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country"); // get user location
		Integer myId = (Integer)req.getSession(true).getAttribute("uid"); // get user ID
		if(myId!=null) // user must be logged in
			{
			
				MyModel balanceModel=new MyModel(); //create a database model class instance
				ArrayList<TransactionModel> myBalanceList=balanceModel.giveTransaction(myId); // give transaction history of this ID
				req.setAttribute("myList", myBalanceList);    // set the balance history in a list to pass to jsp page
				if(myCountry.equals("DE")||myCountry.equals("CH"))
				{
					req.getRequestDispatcher("balanceGrView.jsp").forward(req,resp);
				}
				else
				{
					req.getRequestDispatcher("balanceView.jsp").forward(req,resp);
				}
			}
		
		 else
			{
				req.getRequestDispatcher("/login?token=1").forward(req,resp); // prompt the user to login
			}		
			
	}
	
		
		
		
	
}

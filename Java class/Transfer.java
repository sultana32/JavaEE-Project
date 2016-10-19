package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Transfer extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession ses = req.getSession(false);   // check session
		if (ses == null) 
		{
			// Not created yet. Now do so yourself.
			ses = req.getSession();
			ses.setAttribute("country", "eng");
			req.getRequestDispatcher("/login?token=1").forward(req, resp);  // prompt user to login as no session exists

		}
		// get user language mode and ID from session
		String myCountry = (String) req.getSession(true).getAttribute("country");
		Integer myId = (Integer) req.getSession(true).getAttribute("uid");
		
		if (myId != null) // user must be logged in
		{
			
			String myToken = req.getParameter("token");

			if (myCountry.equals("DE"))

			{
				if (myToken.equals("1")) 
				{
					String myMsg = "Da ist etwas schiefgegangen. Bitte versuchen Sie es erneut!";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				}
				else if (myToken.equals("2")) 
				{
					String myMsg = "Übertragenbetrag muss positiv sein";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else   if (myToken.equals("3"))
				{
					MyModel transferAmount1 = new MyModel();
					int myBalance = transferAmount1.knowBalance(myId);
					String myMsg = "Ihr Ergebnis lautet: " + myBalance + ".Bitte hinterlegen Weitere ersten oder übertragen Sie weniger als  " 
					+myBalance;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else if (myToken.equals("4")) 
				{
					String myMsg = "Ihr vorgesehen Transfer Konto-ID ist nicht vorhanden.";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else if (myToken.equals("5"))
				{
					String myMsg = "Sie können nicht auf Ihr eigenes Konto überweisen"; //help
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				
				else if (myToken.equals("6"))
				{
					String myMsg = "Alle Felder müssen ausgefüllt werden!";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else 
				{
					String myMsg = null;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);
				}

			} 
			else 
			{
				if (myToken.equals("1")) 
				{
					String myMsg = "Something went wrong.Please try again.";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferForm.jsp").forward(req, resp);

				} 
				else if (myToken.equals("2")) 
				{
					String myMsg = "transfer amount must be positive";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferForm.jsp").forward(req, resp);

				} 
				
				else if (myToken.equals("3"))
				{
					MyModel transferAmount1 = new MyModel();
					int myBalance = transferAmount1.knowBalance(myId);
					String myMsg = "Your balance is= " + myBalance + ".Please deposit more or transfer less than  "
							+ myBalance;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferForm.jsp").forward(req, resp);

				} 
				else if (myToken.equals("4")) 
				{
					String myMsg = "Your provided account does not exist"; //help
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else if (myToken.equals("5")) 
				{
					String myMsg = "You can not transfer to your own account";//help
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				}
				
				else if (myToken.equals("6")) 
				{
					String myMsg = "Please fill up all fields!";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferFormGr.jsp").forward(req, resp);

				} 
				else 
				{
					String myMsg = null;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("transferForm.jsp").forward(req, resp);

				}
			}

		} 
		else // user did not log in.prompt him to login
		{
			req.getRequestDispatcher("/login?token=1").forward(req, resp);
		}

	}

}

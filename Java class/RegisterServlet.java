package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false); // get the session
		if (ses == null)
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		
		String myToken=req.getParameter("token");  // what message to show
		
		if(myCountry.equals("DE"))
			
		{
			if(myToken.equals("1"))   // in case of unhandeled exception
			{
				
				String myMsg="Da ist etwas schiefgegangen! Bitte versuchen Sie es erneut!";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
			}
			else if(myToken.equals("2"))   // if pw and confirm pw do not match
			{
				//help
				String myMsg="Ihre Passwörter stimmen nicht überein";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("3"))
			{
				String myMsg="Alle Felder müssen ausgefüllt werden!";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("4"))
			{
				String myMsg="Minimale Passwortlänge: 6";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("5"))   // if user gives an already exist email
			{
				//help
				String myMsg="Ein Benutzer hat bereits diese E-Mail.Passwort/Benutzername vergessen?";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else  //default,no message
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
			}
				
		}
		else
		{
			if(myToken.equals("1"))   // in case of unhandeled exception
			{
				String myMsg="Something went wrong.Please try again";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
			}
			else if(myToken.equals("2"))  // pw and confirm pw do not match
			{
				String myMsg="Your Password did not match.Please try again.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("3"))
			{
				String myMsg="Please fill up all fields";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("4"))
			{
				String myMsg="Password must have 6 char at least";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("5")) // if user gives an already exist email
			{
				String myMsg="A user already has this email.Forget id or pw?";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
			else   // default, no message
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
		}
		
		
	}
}

package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		
		HttpSession ses = req.getSession(false);
		if (ses == null)
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		String myToken=req.getParameter("token");  // what message should be shown 
		
		if(myCountry.equals("DE"))
			
		{
			if(myToken.equals("1"))
			{
				String myMsg="Bitte einloggen!";  // user has not logged in yet
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
			}
		else if(myToken.equals("2"))
			{
				String myMsg="Ihr Benutzername und Passwort sind nicht korrekt.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
					
					
			}
		 else if(myToken.equals("3"))
				{
					String myMsg="Alle Felder müssen ausgefüllt werden!";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
						
						
				}
			
		 else if(myToken.equals("4"))  // after changing password
			{
				String myMsg="Ihr Passwort wurde geändert.Bitte einloggen!";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
					
					
			}
		 else if(myToken.equals("5")) // if someone clicks register link (sent via email) more than once
			{
			 //help
				String myMsg="Sie bereits bestätigt Registrierung.Bitte einloggen!";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
					
					
			}
			else  //default, no message
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
			}
				
		}
		else
		{
			if(myToken.equals("1"))    // user has not yet logged in
			{
				String myMsg="Please login first !";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
					
					
			}
		else if(myToken.equals("2"))
			{
				String myMsg="Your Id and Password did not match.Please try again.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
					
					
			}
			 else if(myToken.equals("3"))
				{
					String myMsg="Please fill up all fields";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
						
						
				}
			
			 else if(myToken.equals("4"))  // after changing password
				{
					String myMsg="Your password has been changed.Please login";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
						
						
				}
			 else if(myToken.equals("5"))  // if someone clicks register link (sent via email) more than once
				{
					String myMsg="You have already confirmed registration .Please login";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("loginFormGr.jsp").forward(req,resp);
						
						
				}
			else           // default,no message
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
					
					
			}
		}
		
		
	}
}

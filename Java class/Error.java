package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Error extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false);
		if (ses == null) {
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		String myToken=req.getParameter("token");
		
		if(myCountry.equals("DE"))
			
		{
			if(myToken.equals("1"))
			{
				String myMsg="Etwas ist schief gelaufen. Bitte versuche es erneut.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
			}
			else if(myToken.equals("2"))
			{
				String myMsg="Ihr Passwort nicht übereinstimmte. Bitte versuche es erneut.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("3"))
			{
				String myMsg="Bitte fill up all fields";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("4"))
			{
				String myMsg="Password muss  6 char at least";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else if(myToken.equals("5"))
			{
				String myMsg="A user already has this email";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
					
					
			}
			else
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerFormGr.jsp").forward(req,resp);
			}
				
		}
		else
		{
			if(myToken.equals("1"))
			{
				String myMsg="Something went wrong.Please try again";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
			}
			else if(myToken.equals("2"))
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
			else if(myToken.equals("5"))
			{
				String myMsg="A user already has this email";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
			else
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("registerForm.jsp").forward(req,resp);
					
					
			}
		}
		
		
	}
}

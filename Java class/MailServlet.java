package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MailServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		
		HttpSession ses = req.getSession(false);  //check session exists
		if (ses == null)
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country"); // get user language mode
		String myToken=req.getParameter("token"); // get what to do token
		
		if(myCountry.equals("DE"))
		{

			  if(myToken.equals("1"))
			{
					String myMsg="Bitte f�llen Sie alle Felder aus";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("mailFormGr.jsp").forward(req,resp);
						
						
			}

			  else  if(myToken.equals("2"))
			{
					String myMsg="Something went wrong.please try again";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("mailFormGr.jsp").forward(req,resp);
						
						
			}
			else // default
			{
				String myMsg=null;
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("mailFormGr.jsp").forward(req,resp);
			}
				
			
		}
		else{
			 if(myToken.equals("1"))
				{
						String myMsg="Please fill up all fields.";
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("mailForm.jsp").forward(req,resp);
							
							
				}
			 else if(myToken.equals("2"))
				{
						String myMsg="Something went wrong.Please try again.";
						req.setAttribute("msg", myMsg);
						req.getRequestDispatcher("mailForm.jsp").forward(req,resp);
							
							
				}
				else // default 
				{
					String myMsg=null;
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("mailForm.jsp").forward(req,resp);
				}
					
	
			
		}
		
		
	}
}

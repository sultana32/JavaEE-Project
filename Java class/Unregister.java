package hasan.com.rashid;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Unregister extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		
		
		String myLink=req.getParameter("key1");         // get the link associated with mail. with this link we'll identify the user
		String myCountry=req.getParameter("key2");      // get user language mode, also associated with mail link
		
		HttpSession ses = req.getSession(true);
		ses.setAttribute("country", myCountry);			// set user language mode
		
		MyModel userUnregister=new MyModel();
		userUnregister.deleteUser(myLink);              // deleting user with the help of the link associated with mail
		//say something after unregister
		if(myCountry.equals("DE"))
		{
			
			req.getRequestDispatcher("afterUnreg.jsp").forward(req,resp);
			
		}
		else
		{
			req.getRequestDispatcher("afterUnregGr.jsp").forward(req, resp);
		}
		
		
		
}
}

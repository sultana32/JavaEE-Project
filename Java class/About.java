package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class About extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
			HttpSession ses = req.getSession(false); // check if session is already created
			if (ses == null) 
			{
			    // Not created yet. Now do so yourself.
			    ses = req.getSession();
			    ses.setAttribute("country", "eng"); // and set default session mode as English
			} 
			String myCountry=(String)req.getSession(true).getAttribute("country"); // get user language mode
			
			
			if(myCountry.equals("CH")||myCountry.equals("DE"))
			{
				req.getRequestDispatcher("/aboutGr.jsp").forward(req, resp);
				
			}
			else
			{
				
				req.getRequestDispatcher("/about.jsp").forward(req, resp);
			}
	}
}


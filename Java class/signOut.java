package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class signOut extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
			
			
			HttpSession ses = req.getSession(true); 	// get the session
			ses.removeAttribute("uid");  			    // remove user ID from this session
			try{
				Thread.sleep(5000);						// just wait some time
			}
			catch(InterruptedException e)
			{
				throw new ServletException(e);
			}
			
			String myCountry=(String)req.getSession(true).getAttribute("country"); // get user language mode
			
			
			if(myCountry.equals("DE")||myCountry.equals("CH"))
			{
				req.getRequestDispatcher("/signoutGr.jsp").forward(req, resp);
			}
			else
			{
				req.getRequestDispatcher("/signout.jsp").forward(req, resp);
			}
			
	}
	}


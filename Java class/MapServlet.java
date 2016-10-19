package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MapServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		HttpSession ses = req.getSession(false); //check session exists
		if (ses == null)
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		
		String myCountry=(String)req.getSession(true).getAttribute("country"); // get user language mode
		
		
		if(myCountry.equals("DE"))
		{
			req.getRequestDispatcher("/mapGr.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/map.jsp").forward(req, resp);
		}
		
		
		  
		
		
		
	}
}

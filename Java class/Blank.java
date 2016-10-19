package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Blank extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false); // check if session is already created
		if (ses == null) {
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");  // get user language mode
		
		
		if(myCountry.equals("DE")||myCountry.equals("CH"))
		{
			req.getRequestDispatcher("/blankGr.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/blank.jsp").forward(req, resp);
		}
		
		
	}
}

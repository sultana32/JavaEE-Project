package hasan.com.rashid;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false); //check if session exists
		if (ses == null) 
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng");
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		
		
		if(myCountry.equals("DE")||myCountry.equals("CH"))
		{
			req.getRequestDispatcher("/imageGr.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/image.jsp").forward(req, resp);
		}
		
		
	}
}

package hasan.com.rashid;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class ForgetId extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false); // check session
		if (ses == null) 
		{
		    // Not created yet. Now do so yourself.
		    ses = req.getSession();
		    ses.setAttribute("country", "eng"); // default session mode is english
		} 
		String myCountry=(String)req.getSession(true).getAttribute("country");
		
		
		if(myCountry.equals("DE"))
			
		{
			req.getRequestDispatcher("/forgetIdGr.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/forgetId.jsp").forward(req, resp);
		}
		
	}
}

package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Home extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
			
			
			String myLang=req.getParameter("lang");
			if(myLang.equals("CH")||myLang.equals("DE")) // load German version if user is in Switzerland or Germany
			{
				
				HttpSession ses = req.getSession(true); // session create
				ses.setAttribute("country", "DE"); // set mood DE
				req.getRequestDispatcher("/willkommen.jsp").forward(req, resp);
			}
			// Otherwise load English version 
			else
			{
				HttpSession ses = req.getSession(true); // session create
				ses.setAttribute("country", "eng"); //set mood eng
				req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
			}
	}
	}


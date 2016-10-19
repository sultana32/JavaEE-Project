package hasan.com.rashid;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class ForgetPw extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		HttpSession ses = req.getSession(false);  // check session
		if (ses == null) 
		{
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
				//There has been some problem

			String myMsg="Da ist etwas schief gegangen!Bitte geben Sie Ihre E-Mail Adresse erneut ein.";
			req.setAttribute("msg", myMsg);
			req.getRequestDispatcher("/forgetPwGr.jsp").forward(req, resp);
			}
			
			else if(myToken.equals("2"))
			{
				//need help
				String myMsg="Das Zeitlimit (1 Stunden) für den Link ist abgelaufen oder einmal verwendet. Bitte loggen Sie sich für eine PasswortÄnderung erneut ein.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("/forgetPwGr.jsp").forward(req, resp);
			}
			
			else if(myToken.equals("3"))
			{
				String myMsg="Da ist etwas schief gegangen! Bitte loggen Sie sich für eine PasswortÄnderung erneut ein.";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("/forgetPwGr.jsp").forward(req, resp);
			}
			else
			{
				String myMsg="Bitte geben Sie Ihre E-Mail Adresse";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("/forgetPwGr.jsp").forward(req, resp);
			}
		}
		else
		{

		
			if(myToken.equals("1"))
			{
			String myMsg="There has been some problem.Please give your email address again";
			req.setAttribute("msg", myMsg);
			req.getRequestDispatcher("/forgetPw.jsp").forward(req, resp);
			}
			
			else if(myToken.equals("2"))
				
				{
				String myMsg="This link is older than 1 hour or used once.Please reuest for pw change again";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("/forgetPw.jsp").forward(req, resp);
				}
			
			else if(myToken.equals("3"))
				
			{
				String myMsg="Some problem in pw change.Please request for pw change again";
				req.setAttribute("msg", myMsg);
			req.getRequestDispatcher("/forgetPw.jsp").forward(req, resp);
			}
			else
			{
				String myMsg="Please give your email address";
				req.setAttribute("msg", myMsg);
				req.getRequestDispatcher("/forgetPw.jsp").forward(req, resp);
			}
		}
		
	}
}

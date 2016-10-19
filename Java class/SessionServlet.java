package hasan.com.rashid;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SessionServlet extends HttpServlet {
	
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
			String changedPath=req.getParameter("prev");
			String myCountry=(String)req.getSession(false).getAttribute("country");
			
			if(myCountry.equals("DE"))
			{
				// in this case we go back to home page
				if(changedPath.equals("home")||changedPath.equals("registerconfirmregister")||changedPath.equals("mylogin"))
				{
					resp.getWriter().println("redirecting to English in 1 sec...");
					resp.setHeader("Refresh", "1; url=/"+"home?lang="+"eng");
					
				}
				else if(changedPath.equals("register")||changedPath.equals("login")||changedPath.equals("deposit")||changedPath.equals("mmail"))
				{
					// in these cases we go to respected class with no message mode
					req.getSession(true).removeAttribute("country");
					req.getSession(true).setAttribute("country", "eng");
					resp.getWriter().println("redirecting to English in 1 sec...");
					resp.setHeader("Refresh", "1; url=/"+changedPath+"?token=0");
				}
				else
				{
					// otherwise go back to respected classes
							req.getSession(true).removeAttribute("country");
							req.getSession(true).setAttribute("country", "eng");
							resp.getWriter().println("redirecting to English in 1 sec...");
							try{
								Thread.sleep(5000); 
							}
							catch(InterruptedException e)
							{
								throw new ServletException(e);
							}
							resp.sendRedirect("/"+changedPath);
							
					}
			}
			else
			{
				if(changedPath.equals("home")||changedPath.equals("registerconfirmregister")||changedPath.equals("mylogin"))
				{
					resp.getWriter().println("Umleiten auf Deutsch in 1 Sekunde...");
					resp.setHeader("Refresh", "1; url=/"+"home?lang="+"DE");
					
				}
				else if(changedPath.equals("register")||changedPath.equals("login")||changedPath.equals("deposit")||changedPath.equals("mmail"))
				{
					req.getSession(true).removeAttribute("country");
					
					req.getSession(true).setAttribute("country", "DE");
					resp.getWriter().println("Umleiten auf Deutsch in 1 Sekunde...");
					resp.setHeader("Refresh", "1; url=/"+changedPath+"?token=0");
				}
				else
				{
					req.getSession(true).removeAttribute("country");
					req.getSession(true).setAttribute("country", "DE");
					resp.getWriter().println("Umleiten auf Deutsch in 1 Sekunde...");
					try{
						Thread.sleep(7000);
					}
					catch(InterruptedException e)
					{
						throw new ServletException(e);
					}
					resp.sendRedirect("/"+changedPath);
				}
			}
			
	}
	}


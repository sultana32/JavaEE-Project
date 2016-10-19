package hasan.com.rashid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Mylogin extends HttpServlet
{
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			 String myname = request.getParameter("name");          // get name and pw from the jsp form
		     String pwd = request.getParameter("pwd");
		     
		     if(myname==null || myname.equals("")||pwd==null||pwd.equals(""))   // if name or pw field is empty, say user to fill all fields
			 {
					request.getRequestDispatcher("/login?token=3").forward(request,response);
			 }
		        
		     MyModel loginUser= new MyModel();
		     String loginName= loginUser.checkUser(pwd);  // get name with this pw from database
		        	 
		     if(loginName.equals(myname))                  // if name and pw is correct
		     {
		        		int uid=loginUser.giveUserId(myname, pwd);          // get user ID
		        		HttpSession ses = request.getSession(true);
		    			ses.setAttribute("uid", uid);                        // set User ID in current session
		    			String myCountry=(String)request.getSession(true).getAttribute("country");
		    			if(myCountry.equals("DE"))
						{
							request.setAttribute("username", myname);
							request.getRequestDispatcher("helloUserGr.jsp").forward(request,response);
							
						}
						else
						{
							request.setAttribute("username", uid);
							request.getRequestDispatcher("helloUser.jsp").forward(request,response);
						}
		    }
		    else //otherwise show the message- ID and pw don't match
		    {
		    			request.getRequestDispatcher("/login?token=2").forward(request,response);
		    }
		        	

			 
			       
		       
		      
		}

}

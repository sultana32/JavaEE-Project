package hasan.com.rashid;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.Timestamp;

import java.util.ArrayList;



@SuppressWarnings("serial")
public class ChangePw extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		 String myCountry=req.getParameter("key2"); //get user language mode
		
		HttpSession ses = req.getSession(true); // check session, if not exist then create one
		ses.setAttribute("country", myCountry); // set user language mode
		
		MyModel pwChangeModel=new MyModel(); // create a database model class instance
		
		// get user data with the encrypted email token
		ArrayList<UserEmailModel> myUserList=pwChangeModel.queryForgetUser(req.getParameter("key1")); 
		
		java.util.Date date= new java.util.Date();  
		
		Timestamp justNow=new Timestamp(date.getTime());  // get just now time- link clicking time
		// get the time difference between request of change pw time and click the link time
		long difference=justNow.getTime()-myUserList.get(0).getForgetDate().getTime();  
		int diffMin=(int) (difference/(1000*60)); // time difference in minute
		int myStatus=myUserList.get(0).getStatus();  // check if the change pw link already clicked or not
		if(myStatus!=1 || diffMin>60)
		{
			// if the change pw link already clicked or the link is older than 1 hour, say the link is invalid
				
				req.getRequestDispatcher("/forgetPw?token=2").forward(req,resp);
			
				
				
		}
		else
		{
				ses.setAttribute("myaddress",myUserList.get(0).getUserMail());	// set user email in session 
				//now prompt the user to give new password
				if(myCountry.equals("DE"))
					
				{
					String myMsg="Bitte geben Sie ein neues Passwort ein.";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("/chngPwGr.jsp").forward(req, resp);
				}
				else
				{
					String myMsg="Please enter new password";
					req.setAttribute("msg", myMsg);
					req.getRequestDispatcher("/chngPw.jsp").forward(req, resp);
				}
		}
		
	}
}

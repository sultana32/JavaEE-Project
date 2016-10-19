package hasan.com.rashid;

import java.io.IOException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class MyChangePw extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession ses = request.getSession(false);
		if (ses == null) 
		{
		    // Not created yet. Now do so yourself.
		    ses = request.getSession();
		    ses.setAttribute("country", "eng");
		   
			
		} 
		String myCountry=(String)request.getSession(true).getAttribute("country"); // get langage mode from session
		
		String email = (String)request.getSession(true).getAttribute("myaddress");// get user email from session
		
		//get form data from jsp
        String pwd =request.getParameter("pwd");
        String confirmpwd = request.getParameter("confirmpwd");
        
        if(pwd==null||pwd.equals(""))
		{
        	// if user submit blank pw,prompt him to give it again
        	if(myCountry.equals("DE"))
    			
    		{
        		String myMsg="Felder müssen ausgefüllt werden!";
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPwGr.jsp").forward(request, response);
    		}
    		else
    		{
    			String myMsg="Password cant be blank";
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPw.jsp").forward(request, response);
    		}
		}
        
        else if(!pwd.equals(confirmpwd))
		{
        	// if pw and confirm pw do not match, tell him
        	if(myCountry.equals("DE"))
    			
    		{
        		String myMsg="Passwörter stimmen nicht überein";//help
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPwGr.jsp").forward(request, response);
    		}
    		else
    		{
    			String myMsg="Password do not match" ;
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPw.jsp").forward(request, response);
    		}
		}
        else if(pwd.length()<6)
		{
        	// if provide pw does not contain 6 char
        	if(myCountry.equals("DE"))
    			
    		{
        		String myMsg="Minimale Passwortlänge: 6";
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPwGr.jsp").forward(request, response);
    		}
    		else
    		{
    			String myMsg="Password must contain at least 6 characters.";
    			request.setAttribute("msg", myMsg);
    			request.getRequestDispatcher("/chngPw.jsp").forward(request, response);
    		}
		}
        else  // pw length=6. pw=confirmPw ,so going ahead
        {
			MyModel pwChange=new MyModel();
			int mySuccess=pwChange.changeUserPw(email, pwd); // save new password
			int mySuccess2=pwChange.changeStatus(email);  // save that the link is already used
			if(mySuccess>0 && mySuccess2 >0) // if both save worked well
			{
				// email sending preparation to tell the user that his pw has been recently changed
				Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);
		        String msgBody="sultana";
		        if(myCountry.equals("DE"))
	    			
	    		{
		        		msgBody = "Ihr Passwort wurde geändert.";
	    		}
		        else
		        {
		        		msgBody = "Your password have been recently chnaged";
		        }
		        
		 
		        try 
		        {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("sultana.buet@gmail.com",
		                    "ABC mail"));
		            
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "Mr. User"));
		            if(myCountry.equals("eng"))
		            {
		            		msg.setSubject("ABC password changed");
		            }
		            else
		            	
		            {
		            		msg.setSubject("Passwort Meldung");
		            }
		            msg.setText(msgBody);
		            Transport.send(msg);  // email sent
		 
		        } 
		        catch (Exception e) 
		        {
		        	// if there has been a problem in email sending
						request.getRequestDispatcher("/forgetPw?token=3").forward(request, response);
					
				}
		        // everything went fine, pw changed successfully,now prompt user to login
				request.getRequestDispatcher("/login?token=4").forward(request,response);
				
			}
			else   // there has been problem in dbs saving, tell the user to request pw change again
			{
				request.getRequestDispatcher("/forgetPw?token=3").forward(request, response);
				
			}
        }
		
	}
}

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
public class MyForgetId extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String myCountry=(String)request.getSession(false).getAttribute("country");  // get language mode
		
		
	       
	        String email = request.getParameter("email");  // get form data
	        
	        if(email==null||email.equals(""))  // if email field is blank, say the user to fill it up
			{
				request.getRequestDispatcher("/forgetId").forward(request,response);
			}
	        MyModel forgetIdModel=new MyModel();
	        int emailExist=forgetIdModel.emailCheck(email);  // check if a user associated with this email
        	
	        
	        // preparation of sending email
	        
	        	Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);
		        String msgBody=forgetIdModel.giveUserName(email);
		       
		       if(myCountry.equals("eng"))
		       {
		    	   if(emailExist==0)  // no user associated with the provided email
		        	{
		    		   msgBody ="Sorry,there is no user associated with this email. "+System.lineSeparator()+" Click to register: "
		    				   +"http://1-dot-rashid-1048.appspot.com/register?token=0";
		        	}
		        	else
		        	{
		    	   
		        		String yourName=forgetIdModel.giveUserName(email);
msgBody ="You have forgotten your ABC user Id.Here it is: "+yourName+System.lineSeparator()+"  Click to login: "+
		"http://1-dot-rashid-1048.appspot.com/login?token=0";
		        	}
		       	}
		       else
		       {
		    	   if(emailExist==0)
		        	{
		    		   msgBody ="Sorry, es gibt keine Benutzer mit dieser E-Mail zugeordnet . "+System.lineSeparator()+" Klicken Sie hier, sich zu registrieren : "
		    				   +"http://1-dot-rashid-1048.appspot.com/register?token=0";
		        	}
		        	else
		        	{
		    	   
		        		String yourName=forgetIdModel.giveUserName(email);
msgBody ="hier ist Ihre Id : "+yourName+System.lineSeparator()+" Klicken Sie um sich anzumelden : "+System.lineSeparator()+
		"http://1-dot-rashid-1048.appspot.com/login?token=0";
		        	}
		       }
		        try 
		        {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("sultana.buet@gmail.com",
		                    "ABC admin"));
		            
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "Mr. User"));
				            if(myCountry.equals("eng"))
				            {
				            		msg.setSubject("ABC ID restore");
				            }
				            else
				            	
				            {
				            		msg.setSubject("ABC ID wiederherstellen");
				            }
		            msg.setText(msgBody);
		            Transport.send(msg);
		            
			       
		        } 
		        catch (Exception e)
		        {
		        	// if any problem in sending email,tell the user
			           request.getRequestDispatcher("/register?token=1").forward(request,response);
			    }
		        // if everything went fine, say the user that an email has been sent with his ID
		        if(myCountry.equals("DE"))
				{
				
					request.getRequestDispatcher("afterForgetIdGr.jsp").forward(request,response);
					
				}
				else
				{
					request.getRequestDispatcher("afterForgetId.jsp").forward(request, response);
				}
	        }
	       
	      
	}


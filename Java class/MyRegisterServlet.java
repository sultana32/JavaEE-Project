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
public class MyRegisterServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String myCountry=(String)request.getSession(false).getAttribute("country");
		 Cypher myCypher=new Cypher();   // get an instance of self made cypher class
		 MyModel tempUser= new MyModel(); 
		 
			 String name = request.getParameter("name");           // getting jsp form inputs
		     String email = request.getParameter("email");
		     String pwd =request.getParameter("pwd");
		     String confirmpwd = request.getParameter("confirmpwd");
	       
	        if(name==null || name.equals("")||pwd==null||pwd.equals("")||email==null||email.equals(""))   
			{
	        	 // if any field is not filled out promtp the user to fill it
				request.getRequestDispatcher("/register?token=3").forward(request,response);
			}
	        else if(!pwd.equals(confirmpwd))
	        {
	        	// pw and confirm pwd do not match, then prompt the user 
	        	request.getRequestDispatcher("/register?token=2").forward(request,response);
	        }
	        else if(pwd.length()<=5)
	        {
	        	
	        	request.getRequestDispatcher("/register?token=4").forward(request,response);
	        }
	        
	       else if(tempUser.emailCheck(email)!=0)
        	{
	    	   // the provided email already exists, prompt the user to use different email
        		request.getRequestDispatcher("/register?token=5").forward(request,response);
        	}
        	else
        	{
	        	int success= tempUser.tempUserSave(name, confirmpwd, email);  // save user data in temporary table
	        	if(success==0)     // if there is a problem in saving tell the user that something wrong happened
	        	{
	        		request.getRequestDispatcher("/register?token=1").forward(request,response);
	        	}
	        	
	        	
	        	// processing email to send
	        	Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);
		        String msgBody="sultana";
		        
		        // next 3 lines to encrypt name, email,pwd
		        String name1 = myCypher.oneCypher(name);
			       
		        String email1 = myCypher.oneCypher(email);
		        String pwd1 = myCypher.oneCypher(pwd);
		       if(myCountry.equals("eng"))
		       {
msgBody ="Click this link: "+"http://1-dot-rashid-1048.appspot.com/registerconfirmregister?key1="+ name1+"&key2="+email1+"&key3="+pwd1+"&key4="+"eng";
		       }
		       else
		       {
msgBody ="Klicken Sie den Link: "+"http://1-dot-rashid-1048.appspot.com/registerconfirmregister?key1="+ name1+"&key2="+email1+"&key3="+pwd1+"&key4="+"DE";
		       }
		        try {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("sultana.buet@gmail.com","ABC admin"));
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "Mr. User"));
				            if(myCountry.equals("eng"))
				            {
				            		msg.setSubject("ABC Account activation");
				            }
				            else
				            	
				            {
				            		msg.setSubject("ABC Account Aktivierung");
				            }
		            msg.setText(msgBody);
		            Transport.send(msg);            //email sending
		            
		            // after email is sent, show a after register page to user
		            
					        if(myCountry.equals("DE"))
							{
								request.getRequestDispatcher("afterRegisterGr.jsp").forward(request,response);
							}
							else
							{
								request.getRequestDispatcher("afterRegister.jsp").forward(request,response);
							}
			 
		        	}
	        	catch (Exception e)
		        	{
			           // if there is a problem in sending email, then tell the user that something wrong happened
		        	request.getRequestDispatcher("/register?token=1").forward(request,response);
			           
		           
		        	}
	        }
	       
	      
	}
}


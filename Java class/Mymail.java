package hasan.com.rashid;



import java.io.IOException;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Mymail extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		// get form data
		
		String name = req.getParameter("name");
        String description = req.getParameter("description");
        String email = req.getParameter("email");
        // if any field is empty, prompt the user to fill it up
		if(name==null || name.equals("")||description==null||description.equals("")||email==null||email.equals(""))
		{
			req.getRequestDispatcher("/mmail?token=1").forward(req,resp);
		}
		 else
	     {
		       
		       
        	// preparation of sending mail
        
		        Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);
		 
		        String msgBody = name + "\n" + description + "\n" + email;
		 
		        try 
		        {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("sultana.buet@gmail.com",
		                    "ABC mail"));
		            
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("sultana32@gmail.com", "Mr. User"));
		            msg.setSubject("Feedback");
		            msg.setText(msgBody);
		            Transport.send(msg);  // sending email
		 
		        } 
		        catch (Exception e)
		        {
		        	// say there has been a problem
		        	req.getRequestDispatcher("/mmail?token=2").forward(req,resp);
		        }
		        
		        String myCountry=(String)req.getSession(false).getAttribute("country"); // get language mode from session
		        // say something after sending mail
		        if(myCountry.equals("DE"))
				{
					req.getRequestDispatcher("afterMailGr.jsp").forward(req,resp);
				}
				else
				{
					req.getRequestDispatcher("afterMail.jsp").forward(req,resp);
				}
        }
       
    }
}

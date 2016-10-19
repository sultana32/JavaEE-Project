package hasan.com.rashid;



import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ConfirmRegisterServlet extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		
		// decrypt the keys to get name,email and pwd
		Cypher myCypher=new Cypher();
		String myemail=myCypher.onedeCypher(req.getParameter("key2"));
		String myname=myCypher.onedeCypher(req.getParameter("key1"));
		String mypwd=myCypher.onedeCypher(req.getParameter("key3"));
		
		
		
		MyModel userConfirm=new MyModel();
		String checkName=userConfirm.checkTempUser(myemail);// check email and name in temp user table
		int emailExist=userConfirm.emailCheck(myemail);     // check if any user already associated with this email
    	if(emailExist!=0)
    	{
    		// if a user already associated with this email, prompt the user to login with that ID
    		req.getRequestDispatcher("/login?token=5").forward(req,resp);
    	}
    	
    	
    	else  // email is not already associated
    	{
			if(checkName.equals(myname))   // given name is okay with the email according to temp user table
			{
				String encrypted = null;
				try
				{
					// creating an encrypted link using email to save with the user data which will be used in various operation as unregister
				
				    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
				    SecretKey myDesKey = keygenerator.generateKey();
				    
				    Cipher desCipher;
	
				    // Create the cipher 
				    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				    
				    // Initialize the cipher for encryption
				    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
				    byte[] text = myemail.getBytes();
				    // Encrypt the text
				   byte[] textEncrypted = desCipher.doFinal(text);
				   encrypted=textEncrypted.toString();
				   
				}
		        catch(NoSuchAlgorithmException e)
				{
					e.printStackTrace();
				}
				catch(NoSuchPaddingException e)
				{
					e.printStackTrace();
				}
				catch(InvalidKeyException e)
				{
					e.printStackTrace();
				}catch(IllegalBlockSizeException e)
				{
					e.printStackTrace();
				}
				catch(BadPaddingException e)
				{
					e.printStackTrace();
				} 
			
				String myCountry=req.getParameter("key4");  // get user language mode
				userConfirm.UserSave(myname,mypwd,myemail, encrypted,myCountry);  // save all user data in user table
			 
				HttpSession ses = req.getSession(true);  // now creating session
				ses.setAttribute("country", myCountry);
				int uid=userConfirm.giveUserId(myname, mypwd);  // take the user ID just saved
				ses.setAttribute("uid", uid);                // set uder ID in session
				req.setAttribute("username", myname);
				
				// show welcome message to the registered user
				if(myCountry.equals("DE"))
				{
					
					req.getRequestDispatcher("wilRegister.jsp").forward(req,resp);
					
				}
				else
				{
					req.getRequestDispatcher("welRegister.jsp").forward(req, resp);
				}
			}
    	
			else
			{
				// if name in temp table and name in the clicked link do not match
				req.getRequestDispatcher("/register?token=1").forward(req,resp);
			}
    	}
		
	}
}

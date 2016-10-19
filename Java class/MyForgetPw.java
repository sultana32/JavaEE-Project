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

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@SuppressWarnings("serial")
public class MyForgetPw extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String myCountry=(String)request.getSession(false).getAttribute("country");
		 String email = request.getParameter("email");
	        
	     if(email==null||email.equals(""))   // if email field is empty, prompt user to fill it up
		 {
			request.getRequestDispatcher("/forgetPw?token=0").forward(request,response);
		 }
	     
	    String encrypted = null;
	    MyModel forgetPwModel=new MyModel();
	    int emailExist=forgetPwModel.emailCheck(email);  // check if this email has a user
	     if(emailExist!=0)
     	{ // get an encrypted value of the email
		     try{
	
				    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
				    SecretKey myDesKey = keygenerator.generateKey();
				    
				    Cipher desCipher;
	
				    // Create the cipher 
				    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				    
				    // Initialize the cipher for encryption
				    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
				    byte[] text = email.getBytes();
				    // Encrypt the text
				   byte[] textEncrypted = desCipher.doFinal(text);
				   encrypted=textEncrypted.toString();
		        }
		        catch(NoSuchAlgorithmException e){
					e.printStackTrace();
				}catch(NoSuchPaddingException e){
					e.printStackTrace();
				}catch(InvalidKeyException e){
					e.printStackTrace();
				}catch(IllegalBlockSizeException e){
					e.printStackTrace();
				}catch(BadPaddingException e){
					e.printStackTrace();
				} 
		     int mySuccess=forgetPwModel.forgetSaveFunc(encrypted, email);  // save the email and encrypted value to dbs
		     if(mySuccess!=1) // if there is a problem in saving, tell user
		     {
		    	 request.getRequestDispatcher("/forgetPw?token=1").forward(request,response);
		    	 
		     }
     	}
	     
	     
	     
	       // preparation to send email
        	
	        	Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props, null);
		        String msgBody="sultana";
		       
		        if(myCountry.equals("eng"))
		        {
		    	   if(emailExist==0)  // if no user associated with the provided email
		        	{
		    		   msgBody ="Sorry, es gibt keine Benutzer mit dieser E-Mail zugeordnet. "+System.lineSeparator()+" Klicken Sie hier, sich zu registrieren : "
		    				   +"http://1-dot-rashid-1048.appspot.com/register?token=0";
		        	}
		        	else
		        	{
		    	   //pw change link
		        		msgBody ="Klicken Sie hier: "+"http://1-dot-rashid-1048.appspot.com/chngpw?key1="+ encrypted+"&key2="+"eng"+"&key3="+"0";
		        	}
		        }
		       else
		       {
		    	   if(emailExist==0) // if no user associated with the provided email
		        	{
		    		   msgBody ="Sorry,there is no user associated with this email "+System.lineSeparator()+" Klicken Sie hier, sich zu registrierenClick here to register : "
		    				   +"http://1-dot-rashid-1048.appspot.com/register?token=0";;
		        	}
		        	else
		        	{
		    	   // pw chaging link
msgBody ="Click this link: "+"http://1-dot-rashid-1048.appspot.com/chngpw?key1="+ encrypted+"&key2="+"DE"+"&key3="+"0";
		        	}
		       }
		        try {
		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("sultana.buet@gmail.com",
		                    "ABC admin"));
		            
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "Mr. User"));
				            if(myCountry.equals("eng"))
				            {
				            		msg.setSubject("ABC password restore");
				            }
				            else
				            	
				            {
				            		msg.setSubject("ABC password wiederherstellen");
				            }
		            msg.setText(msgBody);
		            Transport.send(msg);
		            
			       
		        } catch (Exception e)
		        {
			           // if there is a problem,say user
		        	request.getRequestDispatcher("/forgetPw?token=1").forward(request,response);
		        }
		        // if everything went fine, say the user that a pw changing mail has been sent to his account
		        if(myCountry.equals("DE"))
				{
				
					request.getRequestDispatcher("afterForgetPwGr.jsp").forward(request,response);
					
				}
				else
				{
					request.getRequestDispatcher("afterForgetPw.jsp").forward(request, response);
				}
	        }
	       
	      
	}


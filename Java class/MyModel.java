package hasan.com.rashid;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;



public class MyModel {
	
public int tempUserSave(String name, String pwd, String email)  // save user in temporary table
	
	{
		String url = null;
		int success=2;
	    try 
	    {
	    	
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "INSERT INTO forjob.tempuser (name, pwd, email) VALUES( ? , ? , ? )";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			          stmt.setString(1, name);
			          stmt.setString(2, pwd);
			          stmt.setString(3, email);
			          
			         
			          success = stmt.executeUpdate();
			          conn.close();
		       
		      }
		      return success;
	    	
	      } 
	    
		 catch (Exception e)
		 {
			   return 0;
	      
	     } 
	   
	 }
	

public String checkTempUser(String email) // check if a user exists in temp table associating this email

		{
			String url = null;
			String myname="hati"; // dummy value
			
		    try 
		    {
		    	 
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "SELECT name FROM forjob.tempuser WHERE email=?";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				         
				          stmt.setString(1, email);
				          
				         
				          ResultSet rs=stmt.executeQuery();
				         
		
				          while (rs.next()) 
				          {
				             myname=rs.getString("name");
				          }
		
				          
				          conn.close();
			       
			      }
			      return myname;
		    	
		      } 
			      catch (Exception e)
			 {
				    	return myname; // return dummy value if any problem
		      
		     } 
		   
		}


	public void UserSave(String name, String pwd, String email,String link,String lang)// save user
	
	{
			String url = null;
			
		    try 
		    {
		    	
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "INSERT INTO forjob.user (name, pwd, email, link, lang) VALUES( ? , ? , ? ,? , ?)";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				          stmt.setString(1, name);
				          stmt.setString(2, pwd);
				          stmt.setString(3, email);
				          stmt.setString(4, link);
				          stmt.setString(5, lang);
				         
				          stmt.executeUpdate();
				          conn.close();
			       
			      }
			      
		      } 
			      catch (Exception e)
			 {
			    	 e.printStackTrace();
		      
		     } 
		   
	 }


	public ArrayList<TransactionModel> giveTransaction(int uid)   // give transaction history of this user ID
	{
		String url = null;
		ArrayList<TransactionModel> transactionList = new ArrayList<>();
	   
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT amount,type,tdate FROM forjob.transaction WHERE uid=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setInt(1, uid);
			          
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         
			        
				         
				         // Extract data from result set
				         while(rs.next())
				         {
				        	 TransactionModel myTransaction = new TransactionModel();
				        	 myTransaction.setAmount(rs.getInt("amount"));
				        	 myTransaction.setType(rs.getString("type"));
				        	myTransaction.setDate(rs.getDate("tdate"));
				        	 transactionList.add(myTransaction);
				            
				         }
			          
			          conn.close();
		       
		      }
		      return transactionList;
	    	
	      } 
		      catch (Exception e)
		 {
		    	 return transactionList;
	      
	     } 
	    
	   
	 }
	
	public ArrayList<TransactionModel> queryTransaction(int uid,Date date1, Date date2)  
	{
		 // give transaciton history of this User ID within a time frame
		String url = null;
		  ArrayList<TransactionModel> transactionList = new ArrayList<>();
	    //ArrayList<TransactionModel> transactionHistory = new ArrayList<TransactionModel>();
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT amount,type,tdate FROM forjob.transaction WHERE uid=? AND tdate BETWEEN ? AND ?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setInt(1, uid);
			          stmt.setDate(2, (java.sql.Date) date1);
			          stmt.setDate(3, (java.sql.Date) date2);
			          
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         
			        
				         
				         // Extract data from result set
				         while(rs.next())
				         {
				        	 TransactionModel myTransaction = new TransactionModel();
				        	 myTransaction.setAmount(rs.getInt("amount"));
				        	 myTransaction.setType(rs.getString("type"));
				        	myTransaction.setDate(rs.getDate("tdate"));
				        	 transactionList.add(myTransaction);
				            
				         }
			          
			          conn.close();
		       
		      }
		      return transactionList;
	    	
	      } 
	    
		 catch (Exception e)
		 {
		    	 return transactionList;
	      
	     } 
	    
	   
	 }
	
	public String checkUser(String pwd) // check if a user have this pw

	{
		String url = null;
		String myname="hati";//dummy value
		
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT name FROM forjob.user WHERE pwd=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setString(1, pwd);
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         

			          while (rs.next()) 
			          {
			             myname=rs.getString("name");
			          }

			          
			          conn.close();
		       
		      }
		      return myname;
	    	
	      } 
		 catch (Exception e)
		 {
			    	return myname;
	      
	     } 
	   
	 }

	public String giveUserName(String email)  // give the user name from user table associated with this email

	{
		String url = null;
		String myname="hati"; //dummy
		
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT name FROM forjob.user WHERE email=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setString(1, email);
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         

			          while (rs.next()) 
			          {
			             myname=rs.getString("name");
			          }

			          
			          conn.close();
		       
		      }
		      return myname;
	    	
	      } 
		catch (Exception e)
		 {
			    	return myname;// return dummy
	      
	     } 
	   
	 }

	
	
	public int userExist(int id) // check if a user has this ID

	{
		String url = null;
		int myname=1;//dummy, no user has this id
		
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT name FROM forjob.user WHERE uid=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setInt(1, id);
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         

			          if (!rs.isBeforeFirst() ) // if the resultset has no row
			          {    
			        	  myname=0; 
			        } 

			          
			          conn.close();
		       
		      }
		      return myname;
	    	
	      } 
		 catch (Exception e)
		 {
			    	return myname;
	      
	     } 
	   
	 }
	
	public int emailCheck(String email) // check if the email has a user

	{
		String url = null;
		int myname=1;
		
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT name FROM forjob.user WHERE email=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setString(1, email);
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         

			          if (!rs.isBeforeFirst() ) // if result set has no row
			          {    
			        	  myname=0; 
			        } 

			          
			          conn.close();
		       
		      }
		      return myname;
	    	
	      } 
	    
		 catch (Exception e)
		 {
			    	return myname;
	      
	     } 
	   
	 }

	public int giveUserId(String name,String pwd)// what is the ID with this email and pwd

	{
		String url = null;
		int uid=0;
		
	    try 
	    {
	    	 
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "SELECT uId FROM forjob.user WHERE pwd=? AND name=?";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			         
			          stmt.setString(1, pwd);
			          stmt.setString(2, name);
			          
			         
			          ResultSet rs=stmt.executeQuery();
			         

			          while (rs.next()) 
			          {
			             uid=rs.getInt("uId");
			          }

			          
			          conn.close();
		       
		      }
		      return uid;
	    	
	      } 
		 catch (Exception e)
		 {
			    	return 1;
	      
	     } 
	   
	 }
	
public int depositFunc(int id, String type, int amount)  // save the transaction -deposit
	
	{
		String url = null;
		int success=2;
	    try 
	    {
	    	Date myDate = new Date();
	        
	    	
		      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
		      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
			        Connection conn = DriverManager.getConnection(url);
			       
			        String statement = "INSERT INTO forjob.transaction (uid, type, amount,tdate) VALUES( ? , ? , ? ,?)";
			          PreparedStatement stmt = conn.prepareStatement(statement);
			          stmt.setInt(1, id);
			          stmt.setString(2, type);
			          stmt.setInt(3, amount);
			          stmt.setDate(4, new java.sql.Date(myDate.getTime()));
			          
			         
			          success = stmt.executeUpdate();
			          conn.close();
		       
		      }
		      return success;
	    	
	      } 
		      catch (Exception e)
		 {
			    	return 0;
	      
	     } 
	   
	 }

public int forgetSaveFunc(String encryptedEmail, String email) // save pw change request

{
	String url = null;
	int success=2;
    try 
    {
    	java.util.Date today = new java.util.Date();
        
    	
	      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
	      {
	    	  
		        // Load the class that provides the new "jdbc:google:mysql://" prefix.
		        Class.forName("com.mysql.jdbc.GoogleDriver");
		        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
		        Connection conn = DriverManager.getConnection(url);
		       
		        String statement = "INSERT INTO forjob.forgettable (encryptedMail, email,forgetDate,obostha) VALUES( ? , ? , ? , ?)";
		          PreparedStatement stmt = conn.prepareStatement(statement);
		          stmt.setString(1, encryptedEmail);
		          stmt.setString(2, email);
		          
		          stmt.setTimestamp(3, new java.sql.Timestamp(today.getTime()));
		          
		          stmt.setInt(4,1);  // link has not been used, so 1
		          success = stmt.executeUpdate();
		          conn.close();
	       
	      }
	      return success;
    	
      } 
	  catch (Exception e)
	 {
		    	return 0;
      
     } 
   
 }

public void forgetSaveTest(int test) // check whether the link has been used or not

{
	String url = null;
	
    try 
    {
    	
        
    	
	      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
	      {
	    	  
		        // Load the class that provides the new "jdbc:google:mysql://" prefix.
		        Class.forName("com.mysql.jdbc.GoogleDriver");
		        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
		        Connection conn = DriverManager.getConnection(url);
		       
		        String statement = "INSERT INTO forjob.forgettable (obostha) VALUES( ? )";
		        PreparedStatement stmt = conn.prepareStatement(statement);
		          
		          
		          stmt.setInt(1,test);
		          
		          conn.close();
	       
	      }
	     
    	
      } 
	      catch (Exception e)
	 {
		    	
      
     } 
   
 }

public int changeStatus(String email) // the link associated with this email has been used, so change the status as 0

{
	String url = null;
	int success=2;
    try 
    {
    	
        
    	
	      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
	      {
	    	  int myStatus=0;
		        // Load the class that provides the new "jdbc:google:mysql://" prefix.
		        Class.forName("com.mysql.jdbc.GoogleDriver");
		        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
		        Connection conn = DriverManager.getConnection(url);
		       
		        String statement = "UPDATE forjob.forgettable SET obostha=? WHERE email=?";
		          PreparedStatement stmt = conn.prepareStatement(statement);
		          stmt.setInt(1, myStatus);
		          stmt.setString(2, email);
		          
		          success=stmt.executeUpdate();
		          
		          conn.close();
	       
	      }
	      return success;
    	
      } 
	 catch (Exception e)
	 {
		    	return 0;
      
     } 
   
 }
		public int withdrawFunc(int id, String type, int amount) // save the transaction withdraw
		
		{
			String url = null;
			int success=2;
		    try 
		    {
		    	Date myDate = new Date();
		        
		    	
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "INSERT INTO forjob.transaction (uid, type, amount,tdate) VALUES( ? , ? , ? ,?)";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				          stmt.setInt(1, id);
				          stmt.setString(2, type);
				          stmt.setInt(3, amount);
				          stmt.setDate(4, new java.sql.Date(myDate.getTime()));
				          
				         
				          success = stmt.executeUpdate();
				          conn.close();
			       
			      }
			      return success;
		    	
		      } 
			 catch (Exception e)
			 {
				    	return 0;
		      
		     } 
		   
		 }
public ArrayList<UserEmailModel> queryForgetUser (String encryptedEmail)    // get user data associated with this encrypted link
		{
			String url = null;
			ArrayList<UserEmailModel> userList = new ArrayList<>();
		   
		    try 
		    {
		    	 
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "SELECT email,forgetDate,obostha FROM forjob.forgettable WHERE encryptedMail=? ORDER BY forgetDate ASC";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				         
				          stmt.setString(1, encryptedEmail);
				         
				          
				          
				         
				          ResultSet rs=stmt.executeQuery();
				         
				        
					         
					         // Extract data from result set
					         while(rs.next())
					         {
					        	 UserEmailModel myuser = new UserEmailModel();
					        	 myuser.setUserMail(rs.getString("email"));
					        	
					        	myuser.setForgetDate(rs.getTimestamp("forgetDate"));
					        	myuser.setStatus(rs.getInt("obostha"));
					        	userList.add(myuser);
					            
					         }
				          
				          conn.close();
			       
			      }
			      return userList;
		    	
		      } 
			 catch (Exception e)
			 {
			    	 return userList;
		      
		     } 
		    
		   
		 }

public int knowBalance(int id) // know the current balance of this ID

		{
			String url = null;
			int success=2;
		    try 
		    {
		    	
		    	
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "SELECT SUM(amount) FROM forjob.transaction WHERE uid=?";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				          stmt.setInt(1, id);
				          
		
				          ResultSet rs=stmt.executeQuery();
				         
		
				          while (rs.next()) 
				          {
				             success=rs.getInt(1);
				          }
		
				          conn.close();
			       
			      }
			      return success;
		    	
		      } 
			catch (Exception e)
			 {
				    	return 0;
		      
		     } 
		   
		 }

		public int changeUserPw(String email,String pwd)  // pw update
		
		{
			String url = null;
			int success=2;
		    try 
		    {
		    	
		    	
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "UPDATE forjob.user SET pwd=? WHERE email=?";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				          stmt.setString(1, pwd);
				          stmt.setString(2, email);
		
				         success=stmt.executeUpdate();
				         
		
				         
				          conn.close();
			       
			      }
			      return success;
		    	
		      } 
			  catch (Exception e)
			 {
				    	return 0;
		      
		     } 
		   
		 }
		public ArrayList<UserModel> allUser()   // get all registered user data to send dialy email
		{
			String url = null;
			  ArrayList<UserModel> UserList = new ArrayList<>();
		    //ArrayList<TransactionModel> transactionHistory = new ArrayList<TransactionModel>();
		    try 
		    {
		    	 
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "SELECT * FROM forjob.user";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				         
				          
				          
				          
				         
				          ResultSet rs=stmt.executeQuery();
				         
				        
					         
					         // Extract data from result set
					         while(rs.next())
					         {
					        	UserModel myUser = new UserModel();
					        	
					        	myUser.setuId(rs.getInt("uId"));
					        	myUser.setName(rs.getString("name"));
					        	myUser.setEmail(rs.getString("email"));
					        	myUser.setLink(rs.getString("link"));
					        	myUser.setLang(rs.getString("lang"));
					        	UserList.add(myUser);
					            
					         }
				          
				          conn.close();
			       
			      }
			      return UserList;
		    	
		      } 
			 catch (Exception e)
			 {
			    	 return UserList;
		      
		     } 
		    
		   
		 }

public void deleteUser (String link)   // delete user data from database
		{
			String url = null;
			 
		    try 
		    {
		    	 
			      if (SystemProperty.environment.value() ==SystemProperty.Environment.Value.Production)
			      {
				        // Load the class that provides the new "jdbc:google:mysql://" prefix.
				        Class.forName("com.mysql.jdbc.GoogleDriver");
				        url = "jdbc:google:mysql://rashid-1048:kosto/forjob?user=root";
				        Connection conn = DriverManager.getConnection(url);
				       
				        String statement = "DELETE FROM forjob.user WHERE link=?";
				          PreparedStatement stmt = conn.prepareStatement(statement);
				         
				          stmt.setString(1,link);
				         
				          
				          stmt.executeUpdate();
				         
				          
				          
				          conn.close();
			       
			      }
			     
		    	
		      } 
			 catch (Exception e)
			 {
			    	
		     } 
		    
		   
		 }


}

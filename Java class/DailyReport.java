package hasan.com.rashid;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DailyReport extends HttpServlet
	{
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
		{
			MyModel myReportModel=new MyModel();
			ArrayList<UserModel> myUserList=myReportModel.allUser();  // get all user list
			int i=0;
			for(i=0;i < myUserList.size();i++)  // for all user,do the following
			{
				 // send every user a report
				MonthlyReport myReport=new MonthlyReport();
myReport.doReport(myUserList.get(i).getuId(), myUserList.get(i).getName(), myUserList.get(i).getEmail(), myUserList.get(i).getLink(), myUserList.get(i).getLang());
				
			}

		}
	
}
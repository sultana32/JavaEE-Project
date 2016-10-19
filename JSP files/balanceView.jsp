<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*, java.lang.*" %>
<%@ page import="hasan.com.rashid.TransactionModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABC</title>
			<link rel="stylesheet" type="text/css" href="mycss/bootstrap1.css">
			<link rel="stylesheet" type="text/css" href="mycss/bootstrap2.css">
			<link rel="stylesheet" type="text/css" href="mycss/boxes.css">
			<link rel="stylesheet" type="text/css" href="mycss/vmenu.css">
			<link rel="stylesheet" type="text/css" href="mycss/dropdown.css">
			
			<script src="myjs/jquery.js"></script>
			<script src="myjs/includeElement.js"></script>
			<script src="myjs/langSelector.js"></script>
		
	</head>

	<body class="balance">
		
		<div class="container">  
		<%@ include file="header.jsp" %>
		<div id="includescroll"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebar"></div>
					</div>
					
					
					<div class="span9"> 
						<%int total=0; %>
						<table class="table table-striped">
  						<thead>
    						<tr>
						     
						      <th>Type</th>
						      <th>Amount</th>
						      <th>Date</th>
    						</tr>
 						 </thead>
  						<tbody>
							<% if (request.getAttribute("myList") != null) {
								ArrayList<TransactionModel> transactionList = (ArrayList <TransactionModel>) request.getAttribute("myList");
								
							
							 	for(TransactionModel tran : transactionList) {
							 		total=total+tran.getAmount();
							 		%>
							    <TR>
								     <td><% out.print(tran.getType()); %></td>
								     <td><% out.print(tran.getAmount()); %></td>
								     <td><% out.print(tran.getDate()); %></td>
								   
								        <% } %>
							    </TR>
							<% } %>
							
							<b> Your Balance is : </b>
							<b> <% out.print(total); %> </b>
 						</tbody>
					</table>


	 			</div>
	   
			</div>
		</div>
  </div>
</body>
</html>
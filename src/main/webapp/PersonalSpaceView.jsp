<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entities.Announcement"  %>
    <%@ page import="services.LeMauvaisCoinServices"  %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bienvenue</title>
	</head>
	<body>
		<h2>Bienvenue :  ${pseudonyme} </h2>>
			<tbody>
				<% LeMauvaisCoinServices service = new LeMauvaisCoinServices(); %>
				<% ArrayList<Announcement> listAnnoncementConnectedCustomer = (ArrayList<Announcement>) session.getAttribute("listAnnoncementConnectedCustomer"); %>
				<% for ( Announcement ann : listAnnoncementConnectedCustomer ) {%>
				<tr>
					<td> <%= ann.getTitle() %> </td>
					<td> <%= ann.getPrice() %> </td>
					<td> <%= ann.getType() %> </td>
					<td> <%= ann.getDescription() %> </td>
					<a href=''>Modify</a>
				</tr>
				<% }%>
			</tbody>
		
		<a href='controllercreateannouncement'>Create announcement</a>
		
		
		<!--service.getAllAnnoucementByIdCustomer(service.getCustomerIdByEmail(String emailIn)) -->
		
	</body>
</html>
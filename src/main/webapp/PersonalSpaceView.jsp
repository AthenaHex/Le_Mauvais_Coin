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
					<td> <%= service.getCustomerPseudonymeById(ann.getIdCustomer()) %> </td>	<!-- afficher le nom du Custom et pas son id       -->
				</tr>
				<% }%>
			</tbody>
		
		
		
		
		<!--service.getAllAnnoucementByIdCustomer(service.getCustomerIdByEmail(String emailIn)) -->
		
	</body>
</html>
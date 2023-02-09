<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Register In</title>
	</head>
	
	<body>
		<h4>Enter your personal informations below :</h4>
		
			<form action="controllerregisterin" method="post">
			<label for='txtPseudonyme'>Pseudonyme : </label>
			<input type='text' name='txtPseudonyme'> <br/>
			
			<label for='txtFirstName'>First name : </label>
			<input type='text' name='txtFirstName'> <br/>
			
			<label for='txtLastName'>Last name : </label>
			<input type='text' name='txtLastName'> <br/>
			
			<label for='txtEmail'>Email : </label>
			<input type='email' name='txtEmail'> <br/>
			
			<label for='txtPassword'>Password : </label>
			<input type='password' name='txtPassword'> <br/>
			
			<label for='txtPasswordConfirmation'>Confirm your password : </label>
			<input type='password' name='txtPasswordConfirmation'> <br/>
			
			<input type='submit' value='Go'>
		</form>
		
		<a href='AnnouncementView.jsp'>Back to the menu</a>
		
	</body>
	
</html>
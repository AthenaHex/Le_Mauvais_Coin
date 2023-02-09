<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create View</title>
	</head>
	
	<body>
		<h1>Create Announcement : </h1>
		
		<form action="controllercreateannouncement" method="post">
		
			 <label for='txtTitle'>title</label>
			 <input type='text' name='txtTitle'> <br/>
			
			 <label for='txtprice'>price</label>
			 <input type='number' name='txtPrice'> <br/>
			
			 <label for='txtType'>type</label>
			 <input type='text' name='txtType'> <br/>
			
			 <label for='txtDescription'>Description</label>
			 <input type='text' name='txtDescription'> <br/>
			
			 <input type='submit' value='Validate'>
		</form>
		
		<a href='controllerpersonalspace'>Back to the profile</a>
		
	</body>
</html>
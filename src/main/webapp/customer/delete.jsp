<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
	<h2>Delete Customer</h2>
	<form action="delete" method="post">
		<table>
			<tr>
				<td>Customer ID :</td>
				<td><input type="text" name="customer_id" /></td>
			</tr>
			<td><button type="submit">Submit</button></td>
		</table>
		<input type="hidden" name="action" value="delete" />
	</form>
	<a href="../">Home</a>
</body>
</html>
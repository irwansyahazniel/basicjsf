<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<h2 align="center">Update Customer</h2>
	<form action="update" method="post">
		<table align="center">
		<%
		String customerID = request.getParameter("customer_id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthdate = request.getParameter("birth_date");
		String mobilePhone = request.getParameter("mobile_phone");
		String homePhone = request.getParameter("home_phone");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postal_code");
		%>
			<tr>
				<td>Customer ID :</td>
				<td><input type="text" name="customer_id" value="<%=customerID%>" readonly/></td>
			</tr>
			<tr>
				<td>Nama Depan :</td>
				<td><input type="text" name="first_name" value="<%=firstName%>" /></td>
			</tr>
			<tr>
				<td>Nama Belakang :</td>
				<td><input type="text" name="last_name" value="<%=lastName%>" /></td>
			</tr>
			<tr>
				<td>Tanggal lahir (YYYY-MM-DD) :</td>
				<td><input type="text" name="birth_date" value="<%=birthdate%>" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" value="<%=email%>" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" value="<%=password%>" /></td>
			</tr>
			<tr>
				<td>Home Phone :</td>
				<td><input type="text" name="home_phone" value="<%=homePhone%>" /></td>
			</tr>
			<tr>
				<td>Mobile Phone :</td>
				<td><input type="text" name="mobile_phone" value="<%=mobilePhone%>" /></td>
			</tr>
			<tr>
				<td>Alamat :</td>
				<td><input type="text" name="street" value="<%=street%>" /></td>
			</tr>
			<tr>
				<td>Kota :</td>
				<td><input type="text" name="city" value="<%=city%>" /></td>
			</tr>
			<tr>
				<td>Kode Pos :</td>
				<td><input type="text" name="postal_code" value="<%=postalCode%>" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit" align="center">Update</button>
					<form action="/basicjsf/customer/listcustomer" method="get">
						<input type="submit" value="Cancel" name="Submit" align="center" />
					</form>
				</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="update" />
	</form>
</body>
</html>
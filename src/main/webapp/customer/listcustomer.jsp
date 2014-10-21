<%@ page import="id.co.skyworx.basicjsf.domain.Customer"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
button {
   background:none!important;
    border:none; 
    padding:0!important;
    border-bottom:1px solid #0000EE; 
    cursor: pointer;
    /* font-family: Comic Sans MS;
    font-weight: bold; */
    color: #0000EE;
}
</style>
<title>List Customer</title>
</head>
<body>
	<h2 align="center">Customer Management</h2>
	<!-- listcustomer = nama file jsp yang telah di-mapping -->

	<table border="1" align="center">
		<tr style="background-color: #b2b2b2;">
			<td align="center">ID</td>
			<td align="center">Name</td>
			<td align="center">Email</td>
			<td align="center">Birth Date</td>
			<td colspan="2" align="center">Action</td>
		</tr>
		<!-- looping tr td isi variable dengan getAttribute yang diambil dari
		setAttribute dari fungsi list pada method doGet -->
		<%
			List<Customer> customers = (List<Customer>) request
					.getAttribute("customers");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateParse = null;
			int index = 0;
			for (Customer customer : customers) {
				if (index % 2 == 0) {
					index++;
		%>
		<tr style="background-color: #e5e5e5;">
			<%
				} else {
						index++;
			%>
		
		<tr style="background-color: #ffffff;">
			<%
				}
			%>
			<td><%out.print(customer.getId());%></td>
			<td><%out.print(customer.getFirstName());%></td>
			<td><%out.print(customer.getEmail());%></td>
			<td><%
			dateParse = formatter.format(customer.getBirthDate());
			out.print(dateParse);
			%>
			</td>
			<td>
				<form action="update.jsp" method="post">
					<!-- input type = hidden berfungsi untuk store nilai ke variable -->
					<input type="hidden" name="customer_id" value=<%=customer.getId()%>>
					<input type="hidden" name="first_name"
						value=<%=customer.getFirstName()%>> <input type="hidden"
						name="last_name" value=<%=customer.getLastName()%>> <input
						type="hidden" name="email" value=<%=customer.getEmail()%>>
					<input type="hidden" name="password"
						value=<%=customer.getPassword()%>> <input type="hidden"
						name="birth_date" value=<%=dateParse%>> <input
						type="hidden" name="home_phone" value=<%=customer.getHomePhone()%>>
					<input type="hidden" name="mobile_phone"
						value=<%=customer.getMobileNo()%>> <input type="hidden"
						name="street" value=<%=customer.getAddress().getStreet()%>>
					<input type="hidden" name="city"
						value=<%=customer.getAddress().getCity()%>> <input
						type="hidden" name="postal_code"
						value=<%=customer.getAddress().getPostalCode()%>>
					<button type="submit" value="update">Edit</button>
				</form>
			</td>
			<td>
				<form action="" method="post">
					<input type="hidden" name="customer_id"
						value="<%=customer.getId()%>">
					<button type="submit" name="action" value="delete">Delete</button>
				</form>
			</td>
		</tr>
		<%}	%>
	</table>
	<br>
	<a href="add.jsp.bak"><p style="text-align: center">New Customer...</a>
</body>
</html>
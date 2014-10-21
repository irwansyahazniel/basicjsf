package id.co.skyworx.basicjsf;

import id.co.skyworx.basicjsf.domain.Address;
import id.co.skyworx.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pilihan = req.getParameter("action");

		if (pilihan.equals("add")) {
			// add
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date birthDate = null;
			try {
				birthDate = formatter.parse(req.getParameter("birth_date"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String mobilePhone = req.getParameter("mobile_phone");
			String homePhone = req.getParameter("home_phone");
			String street = req.getParameter("street");
			String city = req.getParameter("city");
			String postalCode = req.getParameter("postal_code");

			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setBirthDate(birthDate);
			customer.setMobileNo(mobilePhone);
			customer.setHomePhone(homePhone);

			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setPostalCode(postalCode);
			customer.setAddress(address);

			// open connection
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			// save ke database
			session.save(customer);

			resp.sendRedirect("listcustomer");

			trx.commit();
			session.close();
		} else if (pilihan.equals("update")) {

			// update
			long customerID = Long.parseLong(req.getParameter("customer_id"));
			String firstName = req.getParameter("first_name");
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date birthDate = null;
			try {
				birthDate = formatter.parse(req.getParameter("birth_date"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String homePhone = req.getParameter("home_phone");
			String mobilePhone = req.getParameter("mobile_phone");
			String street = req.getParameter("street");
			String city = req.getParameter("city");
			String postalCode = req.getParameter("postal_code");

			// open connection
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			Customer customer = (Customer) session.get(Customer.class,
					 customerID);
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setBirthDate(birthDate);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setHomePhone(homePhone);
			customer.setMobileNo(mobilePhone);
			customer.getAddress().setStreet(street);
			customer.getAddress().setCity(city);
			customer.getAddress().setPostalCode(postalCode);
			
			// save ke database
			session.update(customer);

			resp.sendRedirect("listcustomer");

			trx.commit();
			session.close();

		} else if (pilihan.equals("delete")) {
			long customerID = Long.parseLong(req.getParameter("customer_id"));

			// open connection
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			Customer customer = (Customer) session.get(Customer.class,
					customerID);

			session.delete(customer);

			trx.commit();
			session.close();

			// action setelah delete akan di bawa kembali ke list, sebagai
			// auto-refresh
			resp.sendRedirect("listcustomer");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session = HibernateUtil.openSession();

		Query query = session.createQuery("FROM Customer");
		List<Customer> customers = query.list();

		req.setAttribute("customers", customers);

		req.getRequestDispatcher("listcustomer.jsp").forward(req, resp);
		session.close();
	}

}

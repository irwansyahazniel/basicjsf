package id.co.skyworx.basicjsf.controller;

import id.co.skyworx.basicjsf.HibernateUtil;
import id.co.skyworx.basicjsf.domain.Customer;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerListController {
	
	private List<Customer> customers;
	
	public CustomerListController() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		this.customers = session.createQuery("FROM Customer").list();
		
		trx.commit();
		session.close();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}

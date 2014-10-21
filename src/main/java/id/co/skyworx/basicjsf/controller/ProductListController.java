package id.co.skyworx.basicjsf.controller;

import id.co.skyworx.basicjsf.HibernateUtil;
import id.co.skyworx.basicjsf.domain.Product;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ProductListController {
	
private List<Product> products;
	
	public ProductListController() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		this.products = session.createQuery("FROM Product").list();
		
		trx.commit();
		session.close();
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}

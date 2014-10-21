package id.co.skyworx.basicjsf.controller;

import id.co.skyworx.basicjsf.HibernateUtil;
import id.co.skyworx.basicjsf.domain.Category;
import id.co.skyworx.basicjsf.domain.Product;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ProductController {
	Long productId;
	Long categoryId;
	String productName;
	String categoryName;
	String description;
	BigDecimal price;
	Integer stock;
	
	public ProductController() {
		
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		
		if (id != null) {
			this.productId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			Product product = (Product) session.get(Product.class, this.productId);
			
			// isi field form dengan attribute product
			this.productName = product.getName();
			this.description = product.getDescription();
			this.price = product.getPrice();
			this.stock = product.getStock();
			this.categoryName = product.getCategory().getName();
			
			trx.commit();
			session.close();
		}
		
	}
	
	public void save() {

		Product product = new Product();
		Category category = new Category();
		
		// open connection
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		product.setId(productId);
		
		product.setName(productName);
		product.setDescription(description);
		product.setPrice(price);
		product.setStock(stock);
		
		category.setId(categoryId);
		category.setName(categoryName);
		
		product.setCategory(category);
		
		// save ke database
		session.saveOrUpdate(product);
		session.saveOrUpdate(category);

		trx.commit();
		session.close();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}

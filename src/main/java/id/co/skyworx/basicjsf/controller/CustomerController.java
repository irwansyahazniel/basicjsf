package id.co.skyworx.basicjsf.controller;

import id.co.skyworx.basicjsf.HibernateUtil;
import id.co.skyworx.basicjsf.domain.Address;
import id.co.skyworx.basicjsf.domain.Customer;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String password;
	private String homePhone;
	private String mobilePhone;
	private String salutation;
	private Character gender;

	private String alamat;
	private String kota;
	private String postalCode;

	private Long customerId;
	private Long addressId;

	public CustomerController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		if (id != null) {
			this.customerId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			Customer customer = (Customer) session.get(Customer.class, customerId);
			// isi field controller dengan get field customer
			
			this.addressId = customer.getAddress().getId();
			
			this.firstName = customer.getFirstName();
			this.lastName = customer.getLastName();
			this.birthDate = customer.getBirthDate();
			this.email = customer.getEmail();
			this.password = customer.getPassword();
			this.homePhone = customer.getHomePhone();
			this.mobilePhone = customer.getMobileNo();
			this.gender = customer.getGender();
			this.salutation = customer.getSalutation();

			this.alamat = customer.getAddress().getStreet();
			this.kota = customer.getAddress().getCity();
			this.postalCode = customer.getAddress().getPostalCode();
			
			trx.commit();
			session.close();
		}
	}

	public void save() {

		Customer customer = new Customer();
		// open connection
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		customer.setId(this.customerId);

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBirthDate(birthDate);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobilePhone);
		customer.setGender(gender);
		customer.setSalutation(salutation);

		Address address = new Address();

		address.setId(this.addressId);
		
		address.setStreet(alamat);
		address.setCity(kota);
		address.setPostalCode(postalCode);

		customer.setAddress(address);

		// save ke database
		session.saveOrUpdate(customer);

		trx.commit();
		session.close();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}

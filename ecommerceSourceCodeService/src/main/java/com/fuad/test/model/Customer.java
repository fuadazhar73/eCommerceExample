package com.fuad.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuad.test.model.Cart;
import com.fuad.test.model.Code;
import com.fuad.test.model.ProductComment;
import com.fuad.test.model.Role;
import com.fuad.test.model.ShippingAddress;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -1836726872479056197L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @NotEmpty (message = "Email can not be blank")
    private String email;
    
    @NotEmpty (message = "Phone number can not be blank")
    private String phoneNumber;
    
    
    @NotEmpty (message = "Password can not be blank")
    private String password;

    @NotEmpty (message = "Name can not be blank")
    private String customerName;
    
    @Column(columnDefinition="DATETIME")
    private Date registerDate;
    
    @Column(columnDefinition="Gender")
    private String gender;
    
    @Column(columnDefinition="DateOfBirth")
    private String dateOfBirth;
    
    @Column(columnDefinition="StatusLogin")
    private Integer statusLogin;
    
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
    
    @OneToMany(mappedBy = "customer")
    private List<Role> roles;
    
    @OneToMany(mappedBy = "customer")
    private List<ProductComment> productComments;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ShippingAddress> shippingAddresses;
    
    @OneToMany(mappedBy = "customer")
    private List<Code> codes;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(Integer statusLogin) {
		this.statusLogin = statusLogin;
	}
	public List<ProductComment> getProductComments() {
		return productComments;
	}

	public void setProductComments(List<ProductComment> productComments) {
		this.productComments = productComments;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Cart getCart() {
		return cart;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	public List<Code> getCodes() {
		return codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

}

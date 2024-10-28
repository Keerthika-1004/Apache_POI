package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="lumen_customer")
@Entity
public class Customer {
	@Id
	@Column(name="customerId")
	private int customerId;
	
	@Column(name="customerOrderId")
	//@NotBlank(message="Customer Order Id is Mandatory")
	private String customerOrderId;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerContact")
	private long customerContact;
	
	@Column(name="customerStatus")
	private String customerStatus;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public Customer(int customerId, String customerOrderId, String customerName, long customerContact,
			String customerStatus) {
		super();
		this.customerId = customerId;
		this.customerOrderId = customerOrderId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.customerStatus = customerStatus;
	}
	public Customer() {
		super();
		
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerOrderId=" + customerOrderId + ", customerName="
				+ customerName + ", customerContact=" + customerContact + ", customerStatus=" + customerStatus + "]";
	}

	public Customer orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

package com.hasnain.customer.creditDB;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customercomb")
public class Customer {
	
	@Id
	@Column(nullable = false)
	private int customerId;
	
	@Column
	private String customerName;
	
	@Embedded
	private CustomerDetail customerDetail;
	
	public Customer() {
	}
	
	public int getId() {
		return this.customerId;
	}
	public void setId(int id) {
		this.customerId = id;
	}
	
	public String getName() {
		return this.customerName;
	}
	public void setName(String name) {
		this.customerName = name;
	}
	
	public CustomerDetail getDetail() {
		return this.customerDetail;
	}
	public void setDetail(CustomerDetail detail) {
		this.customerDetail = detail;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerDetail="
				+ customerDetail.toString() + "]";
	}
	
	
}

package com.hasnain.customer.creditDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@SecondaryTable(name = "CustomerDetail")
public class CustomerComb {
	@Id
	@Column(nullable = false)
	private int customerId;
	
	@Column(table = "Customer")
	private String customerName;
	
	@Column(table = "CustomerDetail")
	private String customerAddress;
	
	@Column(table = "CustomerDetail")
	private int creditScore;
	
	@Column(table = "CustomerDetail")
	private int rewardPoints;

	public CustomerComb() {
		
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
	
	public String getAddress() {
		return customerAddress;
	}
	public void setAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public String toString() {
		return "CustomerComb [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", creditScore=" + creditScore + ", rewardPoints=" + rewardPoints + "]";
	}
	
}

package com.hasnain.customer.creditDB;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerDetail {
	
	@Column
	private String customerAddress;
	
	@Column
	private int creditScore;
	
	@Column
	private int rewardPoints;

	public CustomerDetail() {
		
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
		return "CustomerDetail [customerAddress=" + customerAddress + ", creditScore=" + creditScore + ", rewardPoints="
				+ rewardPoints + "]";
	}
	
}

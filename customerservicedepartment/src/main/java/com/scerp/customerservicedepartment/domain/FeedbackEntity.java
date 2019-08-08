package com.scerp.customerservicedepartment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedbackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerUsername;
	private String orderId;
	private boolean question1;
	private boolean question2;
	private boolean question3;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public boolean isQuestion1() {
		return question1;
	}
	public void setQuestion1(boolean question1) {
		this.question1 = question1;
	}
	public boolean isQuestion2() {
		return question2;
	}
	public void setQuestion2(boolean question2) {
		this.question2 = question2;
	}
	public boolean isQuestion3() {
		return question3;
	}
	public void setQuestion3(boolean question3) {
		this.question3 = question3;
	}
	
	@Override
	public String toString() {
		return "FeedbackEntity [id=" + id + ", customerUsername=" + customerUsername + ", orderId=" + orderId
				+ ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3 + "]";
	}
	
	
	

}

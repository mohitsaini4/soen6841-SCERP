package com.scerp.salesdepartment.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordertable")
public class OrderEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerUsername;
	private String customerName;
	private String productId;
	private String productName;
	private String deliveryAddress;
	private String quantity;
	private boolean paymentInfo;
	private String processingStatus;
	private Long invoiceId;
	private String totalInvoiceSum;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public boolean isPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(boolean paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public String getProcessingStatus() {
		return processingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getTotalInvoiceSum() {
		return totalInvoiceSum;
	}
	public void setTotalInvoiceSum(String totalInvoiceSum) {
		this.totalInvoiceSum = totalInvoiceSum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", customerUsername=" + customerUsername + ", customerName=" + customerName
				+ ", productId=" + productId + ", productName=" + productName + ", deliveryAddress=" + deliveryAddress
				+ ", quantity=" + quantity + ", paymentInfo=" + paymentInfo + ", processingStatus=" + processingStatus
				+ ", invoiceId=" + invoiceId + ", totalInvoiceSum=" + totalInvoiceSum + "]";
	}
	


}

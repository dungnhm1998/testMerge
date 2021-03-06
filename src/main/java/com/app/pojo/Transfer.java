package com.app.pojo;
// Generated Sep 25, 2020 2:22:03 PM by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Transfer generated by hbm2java
 */
public class Transfer implements java.io.Serializable {

	@Id
	@GeneratedValue // (strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	private Integer version;
	private String fromWalletId;
	private String toWalletId;
	private String type;
	private Long amount;
	private String shipmentId;
	private String details;
	private String financialStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;

	public Transfer() {
	}

	public Transfer(String id) {
		this.id = id;
	}

	public Transfer(String id, String fromWalletId, String toWalletId, String type, Long amount, String shipmentId,
			String details, String financialStatus, Date createdAt, Date updatedAt) {
		this.id = id;
		this.fromWalletId = fromWalletId;
		this.toWalletId = toWalletId;
		this.type = type;
		this.amount = amount;
		this.shipmentId = shipmentId;
		this.details = details;
		this.financialStatus = financialStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getFromWalletId() {
		return this.fromWalletId;
	}

	public void setFromWalletId(String fromWalletId) {
		this.fromWalletId = fromWalletId;
	}

	public String getToWalletId() {
		return this.toWalletId;
	}

	public void setToWalletId(String toWalletId) {
		this.toWalletId = toWalletId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getShipmentId() {
		return this.shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFinancialStatus() {
		return this.financialStatus;
	}

	public void setFinancialStatus(String financialStatus) {
		this.financialStatus = financialStatus;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

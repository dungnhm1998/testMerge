package com.app.pojo;
// Generated Sep 25, 2020 2:22:03 PM by Hibernate Tools 4.3.1

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Addresses generated by hbm2java
 */
public class Addresses implements java.io.Serializable {

	private String id;
	private Integer version;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String name;
	private String company;
	private String phone;
	private String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	private String type;
	private Integer pickupId;
	private String createdBy;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;
	private String updatedBy;

	public Addresses() {
	}

	public Addresses(String id, String city, String state, String zip, String country) {
		this.id = id;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public Addresses(String id, String address1, String address2, String city, String state, String zip, String country,
			String name, String company, String phone, String email, Date createdAt, String type, Integer pickupId,
			String createdBy, Date updatedAt, String updatedBy) {
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.name = name;
		this.company = company;
		this.phone = phone;
		this.email = email;
		this.createdAt = createdAt;
		this.type = type;
		this.pickupId = pickupId;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
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

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPickupId() {
		return this.pickupId;
	}

	public void setPickupId(Integer pickupId) {
		this.pickupId = pickupId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
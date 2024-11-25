package com.finder.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Cannot be Empty")
	private String name;
	
	@NotBlank(message = "Cannot be Empty")
	private String address;
	
	@NotBlank(message = "Cannot be Empty")
	private String city;
	
	@NotBlank(message = "Cannot be Empty")
	private String province;
	
	@NotBlank(message = "Cannot be Empty")
	private int cap;
	
	@NotBlank(message = "Cannot be Empty")
	private float latitude;
	
	@NotBlank(message = "Cannot be Empty")
	private float longitude;
	
	private String phone;
	
	private String hours;
	
	private boolean activity;
	
	private String plusService;
	
	// GETTER AND SETTER
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	public String getPlusService() {
		return plusService;
	}
	public void setPlusService(String plusService) {
		this.plusService = plusService;
	}
}

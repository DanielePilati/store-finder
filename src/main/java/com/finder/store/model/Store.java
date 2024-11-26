package com.finder.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "shops")
public class Store {
	
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
	private String cap;
	
	@NotBlank(message = "Cannot be Empty")
	private String latitude;
	
	@NotBlank(message = "Cannot be Empty")
	private String longitude;
	
	private String phone;
	
	private String openingHours;
	
	private String director;
	
	private String activity;
	
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
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHours() {
		return openingHours;
	}
	public void setHours(String hours) {
		this.openingHours = hours;
	}
	public String isActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getPlusService() {
		return plusService;
	}
	public void setPlusService(String plusService) {
		this.plusService = plusService;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActivity() {
		return activity;
	}
}

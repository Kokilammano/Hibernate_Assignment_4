//Create employee detail table 

package com.abc.domain.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_det")
public class Employ_Det {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private long mobile;
	
	@OneToOne
	@JoinColumn(name="city")
	private Address city;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Address getCity() {
		return city;
	}

	public void setCity(Address city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employ_Det [id=" + id + ", name=" + name + ", mobile=" + mobile + ", city=" + city + "]";
	}
	
	
	
}

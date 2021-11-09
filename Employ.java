//Create employee detail table 

package com.abc.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="emp_detail")
public class Employ {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private long mobile;
	
	@OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Set<Address> addr;

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

	public Set<Address> getAddr() {
		return addr;
	}

	public void setAddr(Set<Address> addr) {
		this.addr = addr;
	}
	
	
}

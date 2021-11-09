/*Example for timestamp and versioning concept
* Create product details table 
*/

package com.abc.timestamp;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Product_det")
public class Product 
{
	@Id
	@Column(name="Product_Id")
	private String id;
	
	@Column(name="Product_Name")
	private String name;
	
	@Column(name="Product_Price")
	private double price;
	
	@Version
	private Integer version;
	
	@Column(name="CreatedBy")
	@CreationTimestamp
	private Timestamp createDateTime;
	
	@Column(name="UpdatedBy")
	@UpdateTimestamp
	private Timestamp updateDateTime;

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}

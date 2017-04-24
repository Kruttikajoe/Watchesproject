package com.niit.watchesbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component

public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supid;
	@NotNull(message ="supname cannot be blank")
	private String supname;
	@NotNull(message ="supaddress cannot be blank")
	private String supaddress;
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupaddress() {
		return supaddress;
	}
	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}

}

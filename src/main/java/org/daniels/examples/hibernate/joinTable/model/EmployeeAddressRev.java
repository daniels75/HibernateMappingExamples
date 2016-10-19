package org.daniels.examples.hibernate.joinTable.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "EMPLOYEE_ADDRESS_REV")
public class EmployeeAddressRev implements Serializable{

	private static final long serialVersionUID = 1L;


//	@Id
//	@Column(name = "id")
//	private Long id;
//	
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	@Id
	@Column(name = "employeeId")
	private Integer employeeId;

	@Id
	@Column(name = "employeeRev")
	private Integer employeeRev;
	
	@Column(name = "addressId")
	private Integer addressId;

	@Column(name = "addressRev")
	private Integer addressRev;


	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmployeeRev() {
		return employeeRev;
	}

	public void setEmployeeRev(Integer employeeRev) {
		this.employeeRev = employeeRev;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getAddressRev() {
		return addressRev;
	}

	public void setAddressRev(Integer addressRev) {
		this.addressRev = addressRev;
	}
	
	
}

package org.daniels.examples.hibernate.joinTable.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "EMPLOYEE_REV")
public class EmployeeRev  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "id2")
	private Integer id2;

	@Column(name = "rev")
	private Integer rev;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id2")
//	private Set<AddressRev> adddressRev;
	
	
//	 @OneToMany(cascade=CascadeType.ALL)
//	    @JoinTable(name="EMPLOYEE_ADDRESS_REV", joinColumns={@JoinColumn(name="employeeId", referencedColumnName="ID2")}
//	    , inverseJoinColumns={@JoinColumn(name="addressId", referencedColumnName="ID2")})
//	 private Set<AddressRev> adddressRev;
	 
	 
	 @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="EMPLOYEE_ADDRESS_REV",
	    joinColumns={@JoinColumn(name="EMPLOYEEID", referencedColumnName="ID2"), @JoinColumn(name="EMPLOYEEREV", referencedColumnName="REV")},
	    inverseJoinColumns={@JoinColumn(name="ADDRESSID", referencedColumnName="ID2"), @JoinColumn(name="ADDRESSREV", referencedColumnName="REV")})
	 private Set<AddressRev> adddressRev;	 
//	 
//    @JoinTable(
//            name="EMPLOYEE_ADDRESS_REV",
//            joinColumns=
//                @JoinColumn(name="employeeId", referencedColumnName="id"),
//            inverseJoinColumns=
//                @JoinColumn(name="addressId", referencedColumnName="id")
//        )
//	private List<AddressRev> addressRev = new ArrayList<>();
	
	

	
	public Set<AddressRev> getAdddressRev() {
		return adddressRev;
	}

	public void setAdddressRev(Set<AddressRev> adddressRev) {
		this.adddressRev = adddressRev;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	public Integer getRev() {
		return rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}
	
	

}

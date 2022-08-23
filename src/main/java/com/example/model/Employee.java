package com.example.model;

import java.sql.Timestamp;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="EmployeeTable")
public class Employee {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employee_id;
	private String firstName;
	private String lastName;
	private String dateOfbirth;
    //@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastupdate=new Timestamp(System.currentTimeMillis());
	
	public Employee() {
		super();
	}

	public Employee(long employee_id, String firstName, String lastName, String dateOfbirth, Timestamp lastupdate) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfbirth = dateOfbirth;
		this.lastupdate = lastupdate;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfbirth=" + dateOfbirth + ", lastupdate=" + lastupdate + "]";
	}
	
}

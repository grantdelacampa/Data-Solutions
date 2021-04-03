/*
 * Grant De La Campa
 * 2021
 * Employee: Employee model
 */
package com.myproject.datasolutions.employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.myproject.datasolutions.assets.Asset;

@Entity
public class Employee {
	
	private int id;
	private String first_name;
	private String last_name;
	private String gender;
	private String birth_date;
	private String hire_date;
	
	//One employee can have many assets
    @OneToMany(mappedBy="employee")
    private Set<Asset> assets = new HashSet<Asset>();
	
	protected Employee() {
	}
	
	protected Employee(int id, String first_name, String last_name, String gender, String birth_date, String hire_date) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.hire_date = hire_date;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthDate() {
		return this.birth_date;
	}
	
	public void setBirthDate(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getHireDate() {
		return this.hire_date;
	}
	
	public void setHireDate(String hire_date) {
		this.hire_date = hire_date;
	}
}

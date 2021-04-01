package com.myproject.datasolutions.assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.myproject.datasolutions.employee.Employee;
import com.opencsv.bean.CsvBindByName;

@Entity
public class Asset {
	private int ast_no;
	@CsvBindByName
	private String aqr_date;
	@CsvBindByName
	private String ast_SN;
	@CsvBindByName
	private String ast_model;
	@CsvBindByName
	private String status;
	@CsvBindByName
	private String manufacturer;
	@CsvBindByName
	private String ast_type;
	
	private Integer emp_id;
	
	// An employee can have many assets
	@ManyToOne
    @JoinColumn(name="id",  insertable = false, updatable = false)
    private Employee employee;
	
	public Asset() {
		
	}
	
	public Asset(String aqr_date, String ast_sn, String ast_model, String status, String manufacturer, String ast_type) {
		this.aqr_date = aqr_date;
		this.ast_SN = ast_sn;
		this.ast_model = ast_model;
		this.status = status;
		this.manufacturer = manufacturer;
		this.ast_type = ast_type;	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAstNo() {
		return ast_no;
	}
	
	public void setAstNo(int astno) {
		this.ast_no = astno;
	}
	
	public String getAqrDate() {
		return this.aqr_date;
	}
	
	public void setAqrDate(String aqrdate) {
		this.aqr_date = aqrdate;
	}
	
	public String getAst_SN() {
		return this.ast_SN;
	}
	
	public void setAst_SN(String ast_sn) {
		this.ast_SN = ast_sn;
	}
	
	public String getAstModel() {
		return this.ast_model;
	}
	
	public void setAstModel(String astmodel) {
		this.ast_model = astmodel;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAst_type() {
		return ast_type;
	}

	public void setAst_type(String ast_type) {
		this.ast_type = ast_type;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	// Cast the passed value as an Integer to handle the NULL case.
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
}
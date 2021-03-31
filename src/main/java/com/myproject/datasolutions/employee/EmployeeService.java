package com.myproject.datasolutions.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	//Inject an instance of employeeRepository
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> listAll(){
		return repo.findAll();
	}
	
	public void save(Employee emp) {
		repo.save(emp);
	}

	public Employee get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void count() {
		repo.count();
	}
}

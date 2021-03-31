/*
 * Grant De La Campa
 * 2021
 * EmployeeRepository: provides the interface for the JpaRepository and all inherited methods.
 */
package com.myproject.datasolutions.employee;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Extends the JpaRepository from spring data JPA
 * Inherited: count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save
 * Domain Type: employee
 * Id type: Integer
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}

package com.example.employeecrud.dao;

import java.util.List;

import com.example.employeecrud.model.Employee;

public interface EmployeeDAO {
	Integer save(Employee employee);
	List<Employee> getAll();
	Employee getById(int id);
	int remove(int id);
	int update(int id, String name, String phone, float salary);
}

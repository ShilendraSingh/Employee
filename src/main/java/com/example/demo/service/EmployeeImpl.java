package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeDoesNotExistException;
import com.example.demo.repository.EmployeeRepo;


@Service
public class EmployeeImpl implements EmployeeService {
	
	@Autowired
private EmployeeRepo employeerepo;

	@Override
	public Employee save(Employee employee)  {
		return employeerepo.save(employee);
	
		
	}

	@Override
	public Employee getById(Long id) {
		Optional <Employee> emp=employeerepo.findById(id);
		if(!emp.isPresent())
		{
			try {
				throw new EmployeeDoesNotExistException("Employee not found");
			} catch (Exception e) {
				org.jboss.logging.Logger logger=LoggerFactory.logger(EmployeeImpl.class);
				logger.error("Id not found");
			}
		}
		return emp.get();
		
		
	}

	@Override
	public void deleteEmployee(@Valid Long id) {
	Optional<Employee> E4 = employeerepo.findById(id);
	if (E4.isPresent()) {
		
		employeerepo.deleteById(id);
	}
		
	
		
		
	}

	@Override
	public List<Employee> getAll(Employee employee) {
		return employeerepo.findAll();
	}

	@Override
	public Employee updateemployee(Employee employee) {
		Optional<Employee> findById = employeerepo.findById(employee.getEmployeeId());
		if (findById.isPresent()) {
			Employee newEmployee= findById.get();
			newEmployee.setEmployeeAdress(employee.getEmployeeAdress());
			newEmployee.setEmployeeMobileNumber(employee.getEmployeeMobileNumber());
			newEmployee.setEmployeeId(employee.getEmployeeId());
			newEmployee.setEmployeeName(employee.getEmployeeName());
			newEmployee=employeerepo.save(newEmployee);
			return newEmployee;
			
		}
		return employee ;
	}

	
		
	}

	

	


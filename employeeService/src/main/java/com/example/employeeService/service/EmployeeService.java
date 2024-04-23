package com.example.employeeService.service;

import com.example.employeeService.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);

    Optional<Employee> updateEmployee(Integer id,Employee employee);
}

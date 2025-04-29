package edu.icet.exam.service;

import edu.icet.exam.dto.Employee;

import java.util.List;

public interface EmployeeService {

    boolean create(Employee employee);

    boolean update(Employee employee);

    List<Employee>getAll();

    Employee search(Long id);

    boolean delete(Long id);
}

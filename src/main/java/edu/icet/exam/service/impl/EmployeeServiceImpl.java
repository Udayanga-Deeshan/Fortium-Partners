package edu.icet.exam.service.impl;

import edu.icet.exam.dto.Employee;
import edu.icet.exam.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public boolean create(Employee employee) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public Employee search(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

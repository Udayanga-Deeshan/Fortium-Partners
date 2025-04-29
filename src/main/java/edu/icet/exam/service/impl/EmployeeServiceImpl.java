package edu.icet.exam.service.impl;

import edu.icet.exam.dto.Employee;
import edu.icet.exam.entity.EmployeeEntity;
import edu.icet.exam.repository.EmployeeRepository;
import edu.icet.exam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper mapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public boolean create(Employee employee) {
        if (employee != null) {
            EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
            employeeRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        if (employee != null && employee.getId() != null) {
            Optional<EmployeeEntity> existing = employeeRepository.findById(employee.getId());
            if (existing.isPresent()) {
                EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
                entity.setCreatedAt(existing.get().getCreatedAt());
                entity.setUpdatedAt(LocalDateTime.now());
                employeeRepository.save(entity);
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll().stream().map(employeeEntity -> mapper.map(employeeEntity,Employee.class))
                .collect(Collectors.toList());

    }

    @Override
    public Employee search(Long id) {
        if(id!=null){
            return mapper.map(employeeRepository.findById(id),Employee.class);
        }

        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (id != null) {
            employeeRepository.deleteById(id);

        }
        return false;
    }
}

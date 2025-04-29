package edu.icet.exam.repository;

import edu.icet.exam.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    boolean existsByEmail(String email);
    Optional<EmployeeEntity> findByEmail(String email);


}

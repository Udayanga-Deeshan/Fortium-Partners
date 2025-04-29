package edu.icet.exam.entity;

import edu.icet.exam.util.DepartmentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name" ,nullable = false)
    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private DepartmentType department;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}

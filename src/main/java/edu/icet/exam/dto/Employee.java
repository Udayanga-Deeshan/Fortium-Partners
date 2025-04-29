package edu.icet.exam.dto;

import edu.icet.exam.util.DepartmentType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Long id;

    private String name;

    private String email;

    private DepartmentType department;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}

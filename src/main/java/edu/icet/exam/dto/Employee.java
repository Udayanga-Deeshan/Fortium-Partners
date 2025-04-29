package edu.icet.exam.dto;

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

    private LocalDate createdAt;

    private LocalDate updatedAt;

}

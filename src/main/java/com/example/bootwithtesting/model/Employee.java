package com.example.bootwithtesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "employee1")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}

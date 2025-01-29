package de.szut.lf8_starter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_lastName")
    private String lastName;

    @Column(name = "employee_firstName")
    private String firstName;

    @Column(name = "employee_street")
    private String street;

    @Column(name = "employee_postcode")
    private String postcode;

    @Column(name = "employee_city")
    private String city;

    @Column(name = "employee_phone")
    private String phone;


    private List<Skill> skillSet;


}

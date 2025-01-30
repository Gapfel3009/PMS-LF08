package de.szut.lf8_starter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private long id;

    private String lastName;

    private String firstName;

    private String street;

    private String postcode;

    private String city;

    private String phone;

    private List<SkillDTO> skillSet;
}

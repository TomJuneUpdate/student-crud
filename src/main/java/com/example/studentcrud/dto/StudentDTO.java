package com.example.studentcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private String fullName;
    private Integer age;
    private String phoneNumber;
    private String address;
    private Integer facebookAccountId;
    private Integer googleAccountId;
}

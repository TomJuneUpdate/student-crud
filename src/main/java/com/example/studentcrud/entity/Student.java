package com.example.studentcrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "STUDENT")
public class Student extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FULLNAME", length = 100)
    private String fullName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "FACEBOOK_ACCOUNT_ID")
    private Integer facebookAccountId;

    @Column(name = "GOOGLE_ACCOUNT_ID")
    private Integer googleAccountId;
}

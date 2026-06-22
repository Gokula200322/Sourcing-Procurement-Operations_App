package com.spo.core_app.models;

import com.spo.core_app.enums.UserStatus;
import com.spo.core_app.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends GlobalRecord {

    private String userId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String address1;
    private String address2;
    private String address3;

    private LocalDate joiningDate;
    private LocalDateTime lastLoginDate;

    private Boolean emailVerified;
    private Boolean mfaEnabled;

    @ManyToOne
    private Company company;

}

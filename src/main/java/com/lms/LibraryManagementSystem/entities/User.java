package com.lms.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String fatherName;
    private String email;
    private String contactNo;
    private String regNo;
    private String address;
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Deposit> deposits = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
}

package com.sprints.onlineVotingSystem.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String passwordHash;
    @Enumerated(EnumType.STRING) @Column(nullable = false)

    // to differentiate between admin and voter?
    private Role role;

    // for eligibility by city
    @Column(nullable = false) private String city;
}
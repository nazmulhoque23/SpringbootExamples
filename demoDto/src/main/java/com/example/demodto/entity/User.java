package com.example.demodto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email_address")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address", nullable =false)
    private String email_address;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "users_role",
                joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name = "ROLE_ID", referencedColumnName="ID")})
    private List<Roles> roles;
}

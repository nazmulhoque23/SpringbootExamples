package com.example.leaveapplication.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @NotNull
    @JsonProperty("userName")
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager")
    private User managerId;*/

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    /*public User getManagerId() {
        return managerId;
    }*/

    public List<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public void setManagerId(User managerId) {
        this.managerId = managerId;
    }*/

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

package com.example.securitymery.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String token;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="userName"), inverseJoinColumns=@JoinColumn(name="roleName"))
    private Set<Role> roles = new HashSet<>();


}

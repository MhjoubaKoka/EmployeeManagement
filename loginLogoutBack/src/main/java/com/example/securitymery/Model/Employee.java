package com.example.securitymery.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}

package com.example.crudemlpoyeeapp.repository;

import com.example.crudemlpoyeeapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}

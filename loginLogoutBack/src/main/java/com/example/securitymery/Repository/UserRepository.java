package com.example.securitymery.Repository;


import com.example.securitymery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
   User getUserByToken(String token);

   Boolean existsByUserName(String username);
}

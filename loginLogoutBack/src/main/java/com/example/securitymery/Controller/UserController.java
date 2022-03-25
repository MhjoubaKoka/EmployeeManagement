package com.example.securitymery.Controller;



import com.example.securitymery.Model.User;
import com.example.securitymery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    PasswordEncoder passwordEncoder;
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }





    @GetMapping("/idUse/{token}")
    public ResponseEntity<?> FindById(@PathVariable("token") String token){
        try {
            User produit=userService.findByToken(token);
            return new ResponseEntity<User>(produit,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}

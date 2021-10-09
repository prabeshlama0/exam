package com.exam.examserver.controller;

import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    // Use of log4j or sl4j
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    @Autowired
     private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // creating the user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
   user.setProfile("default.png");

   // encoding the password with decryptpasswordencoder
     user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
    Set<UserRole> roles= new HashSet<>();
    Role role1 = new Role();
    role1.setRoleId(46L);
    role1.setRoleName("NORMAL");

    UserRole userRole = new UserRole();
    userRole.setRole(role1);
    userRole.setUser(user);

    roles.add(userRole);

     return this.userService.createUser(user,roles);
    }

    // getting the users
 @GetMapping("/{userName}")
 public User getUser(@PathVariable("userName") String name) {
        LOGGER.info("getting the user "+name);
       return this.userService.getUsers(name);
 }

 // delete user by id
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id")Long id ){
        userService.deleteUser(id);
      System.out.println("Deleted the User "+id);
    }
//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<?> exceptionHandler(UsernameNotFoundException ex){
//        return ResponseEntity.notFound();


}

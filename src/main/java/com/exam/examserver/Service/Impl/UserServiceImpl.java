package com.exam.examserver.Service.Impl;

import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.helper.UserFoundException;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // creating the users

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        // user exist or not
         User local=this.userRepository.findByUserName(user.getUserName());
         if(local!=null){
             System.out.println("User is already there");
             throw new UserFoundException();
         }else{
             // create user
             // save roles coz one user can have many roles
             for(UserRole ur: userRoles){
                 roleRepository.save(ur.getRole());
             }
             user.getUserRole().addAll(userRoles);
             local = this.userRepository.save(user);
         }

        return local;
    }

    @Override
    public User getUsers(String userName) {
      return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

package com.exam.examserver.Service.Impl;

import com.exam.examserver.entity.User;
import com.exam.examserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=this.userRepository.findByUserName(userName);
        if (user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("No user Found");
        }

        return user;
    }
}

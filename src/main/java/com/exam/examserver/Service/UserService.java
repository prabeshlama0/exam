package com.exam.examserver.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import org.springframework.stereotype.Service;


import java.util.Set;

public interface UserService {
    // creating the user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUsers(String userName);
    public void deleteUser(Long id);

}

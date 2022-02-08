package com.App.Vet.business.abstracts;

import com.App.Vet.core.entities.User;
import com.App.Vet.entities.dtos.UserUpdateDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    boolean existsByUserName(String userName);
    User saveUser(User user);
    User getCurrentUser();
    User updateUser(UserUpdateDto userUpdateDto);

}

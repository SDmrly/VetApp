package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.AuthenticationService;
import com.App.Vet.core.dataAccess.UserDao;
import com.App.Vet.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationManager implements AuthenticationService {
    private final UserDao userDao;

    @Autowired
    public AuthenticationManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    //Giriş yapan kullanıcı adı
    @Override
    public String getCurrentUserName(){
        UserDetails userDetails = (UserDetails)getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    //Giriş yapan kullanıcı id
    @Override
    public int getCurrentUserId(){
        UserDetails userDetails = (UserDetails)getAuthentication().getPrincipal();
        User user = this.userDao.findByUserName(userDetails.getUsername());
        return user.getId();
    }
}

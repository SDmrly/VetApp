package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.AuthenticationService;
import com.App.Vet.business.abstracts.UserService;
import com.App.Vet.dataAccess.abstracts.RoleDao;
import com.App.Vet.entities.concretes.Role;
import com.App.Vet.core.entities.User;
import com.App.Vet.core.dataAccess.UserDao;
import com.App.Vet.entities.concretes.Information;
import com.App.Vet.entities.dtos.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final  AuthenticationService authenticationService;

    @Autowired
    public UserManager(UserDao userDao, RoleDao roleDao, AuthenticationService authenticationService) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.authenticationService = authenticationService;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean existsByUserName(String userName) {
        return this.userDao.existsByUserName(userName);
    }

    @Override
    public User saveUser(User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       Role userRoles = this.roleDao.findByRoleName("ROLE_USER");
       user.setRoles(List.of(userRoles));
       user.setInformation(new Information());
       return this.userDao.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Geçersiz kullancı adı ve ya şifre.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAutorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAutorities(Collection<Role> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public User getCurrentUser() {
        return this.userDao.findByUserName(authenticationService.getCurrentUserName());
    }

    @Override
    public User updateUser(UserUpdateDto userUpdateDto) {
        User user = this.userDao.findByUserName(authenticationService.getCurrentUserName());

        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setInformation(userUpdateDto.getInformation());

        return this.userDao.save(user);
    }


}

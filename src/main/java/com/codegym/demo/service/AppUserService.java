package com.codegym.demo.service;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username);

        ArrayList<GrantedAuthority> list = new ArrayList<>();
        list.add(appUser.getRole());

        User user = new User(appUser.getUsername(), appUser.getPassword(), list);
        return user;
    }
}

package com.example.service;

import com.example.dao.CustomerDAO;
import com.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerDAO userHibernateDAO;

    CustomUserDetailsService(CustomerDAO userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String password) throws UsernameNotFoundException {
        User user = (User) userHibernateDAO.getUserByPassword(password);
        if(user == null) {
            throw new UsernameNotFoundException(("USER not found"));
        }
        return new CustomUserDetails(user);
    }
}


package com.example.service;

import com.example.dao.CustomerDAO;
import com.example.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class UserService implements CustomerService<User>{

    private final CustomerDAO userHibernateDAO;

    public UserService(CustomerDAO userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }

    @Override
    public List<User> selectAllUsers() {
        return userHibernateDAO.selectAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String email) {
        userHibernateDAO.updateUser(id, name, email);
    }

    @Override
    @Transactional
    public void creatUser(User user) {
        userHibernateDAO.creatUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userHibernateDAO.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return (User) userHibernateDAO.getUserById(id);
    }

    @Override
    public User getUserByPassword(String password) {
        return (User) userHibernateDAO.getUserByPassword(password);
    }

}



package com.example.service;

import com.example.dao.UserHibernateDAO;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserHibernateDAO userHibernateDAO;

    @Autowired
    public UserService(UserHibernateDAO userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }

    /*получить всех пользователей*/
    public List<User> selectAllUsers() {
        return userHibernateDAO.selectAllUsers();
    }

    /*изменение пользователя*/
    @Transactional
    public void updateUser(long id, String name, String lastname, String email) {
        userHibernateDAO.updateUser(id, name, lastname, email);
    }

    /*создать пользователя*/
    @Transactional
    public void creatUser(User user) {
        userHibernateDAO.creatUser(user);
    }

    /*удалить пользователя*/
    @Transactional
    public void deleteUser(long id) {
        userHibernateDAO.deleteUser(id);
    }

    /*получить пользователя по Id*/
    public User selectUserId(long id) {
        return userHibernateDAO.selectUserId(id);
    }

    /*TODO проверка клиента*/
    public User verifyUser(String name, String password) {
        return userHibernateDAO.verifyUser(name, password);
    }
}

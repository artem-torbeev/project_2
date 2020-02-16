package com.example.dao;

import com.example.model.User;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserHibernateDAO implements UserDAO<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> selectAllUsers() {
        return entityManager.createQuery("from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(long id, String name, String lastname, String email) {
        User user = entityManager.find(User.class, id);
        user.setName(name);
        user.setLastname(lastname);
        user.setEmail(email);
    }

    @Override
    public void creatUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public User selectUserId(long id) {
        return entityManager.find(User.class, id);
    }

    public User verifyUser(String name, String password) {
        String hql = "from User u where u.name = :name and u.password = :password";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);
        List<User> userList = query.getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }
}

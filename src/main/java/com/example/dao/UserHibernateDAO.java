package com.example.dao;

import com.example.model.Role;
import com.example.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Set;


@Repository
public class UserHibernateDAO implements CustomerDAO<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> selectAllUsers() {
        return entityManager.createQuery("from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(Long id, String name, String email) {
        User user = entityManager.find(User.class, id);
        user.setUsername(name);
        user.setEmail(email);
    }

    @Override
    public void creatUser(User user) {
        Set<Role> roleSet = user.getRole();
        if (user.getUsername().equals("Admin")){
            TypedQuery<Role> queryOne = entityManager.createQuery("from Role r where r.id = 1", Role.class);
            List<Role> roleAdmin = queryOne.getResultList();
            roleSet.add(roleAdmin.get(0));
        }else {
            TypedQuery<Role> queryTwo = entityManager.createQuery("from Role r where r.id = 2", Role.class);
            List<Role> roleUser = queryTwo.getResultList();
            roleSet.add(roleUser.get(0));
        }
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByPassword(String password) {
        String hql = "from User u where u.password = :password";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("password", password);
        List<User> userList = query.getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }
}

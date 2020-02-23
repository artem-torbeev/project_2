package com.example.dao;

import java.util.List;

public interface CustomerDAO<T>{

    List<T> selectAllUsers();

    void updateUser(Long id, String name, String email);

    void creatUser(T user);

    void deleteUser(Long id);

    T getUserById(Long id);

    T getUserByPassword(String password);
}

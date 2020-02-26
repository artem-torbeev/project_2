package com.example.service;


import java.util.List;

public interface CustomerService<T> {

    List<T> selectAllUsers();

    void updateUser(Long id, String name, String email);

    void creatUser(T user);

    void deleteUser(Long id);

    T getUserById(Long id);

    T getUserByUsername(String username);
}

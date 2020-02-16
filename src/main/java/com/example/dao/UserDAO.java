package com.example.dao;

import java.util.List;

public interface UserDAO <T>{
    /*получить всех пользователей*/
    List<T> selectAllUsers();

    /*изменение пользователя*/
    void updateUser(long id, String name, String lastname, String email);

    /*создать пользователя*/
    void creatUser(T user);

    /* удалить пользователя*/
    void deleteUser(long id);
}

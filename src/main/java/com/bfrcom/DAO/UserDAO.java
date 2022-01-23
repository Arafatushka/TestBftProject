package com.bfrcom.DAO;

import com.bfrcom.model.User;

import java.util.List;

public interface UserDAO {

        User findByName(String name);
        List<User> findAll();

}

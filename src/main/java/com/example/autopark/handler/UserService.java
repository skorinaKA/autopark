package com.example.autopark.handler;

import com.example.autopark.entity.Users;

public interface UserService {
    Iterable<Users> listUsers();
    Users create(Users user);

    Users getCurrentUser();
}

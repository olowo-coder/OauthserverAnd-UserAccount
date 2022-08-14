package com.example.authenticatioserver.service;

import com.example.authenticatioserver.entity.User;
import com.example.authenticatioserver.entity.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

}

package com.order.tracking.service;

import com.order.tracking.entity.User;

public interface UserService {
    User register(User user);
    User login(String username, String password);
}

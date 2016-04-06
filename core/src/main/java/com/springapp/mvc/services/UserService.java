package com.springapp.mvc.services;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Gataullin Kamil
 * 28.03.2016 21:26
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void add(UserInfo userInfo) {
        userRepository.add(userInfo);
    }

    public UserInfo getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}

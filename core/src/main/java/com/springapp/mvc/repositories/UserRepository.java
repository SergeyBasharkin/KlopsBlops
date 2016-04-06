package com.springapp.mvc.repositories;

import com.springapp.mvc.common.UserInfo;

/**
 * Gataullin Kamil
 * 28.03.2016 21:21
 */
public interface UserRepository {

    void add(UserInfo userInfo);

    UserInfo getUserByLogin(String login);
}

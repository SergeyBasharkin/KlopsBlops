package com.springapp.mvc.repositories;

import com.springapp.mvc.common.UserInfo;

/**
 *
 */
public interface UserRepository {

    void add(UserInfo userInfo);

    UserInfo getUserByLogin(String login);
}

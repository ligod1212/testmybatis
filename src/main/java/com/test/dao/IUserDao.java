package com.test.dao;

import com.test.domain.User;

import java.util.List;

/**
 * zl
 * 2019/12/24
 **/
public interface IUserDao {


    List<User> findAll();
}

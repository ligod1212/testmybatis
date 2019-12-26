package com.test.dao;

import com.test.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * zl
 * 2019/12/24
 **/
public interface IUserDao {

   // @Select("select * from user ")
    List<User> findAll();

    void saveUser(User user);

}

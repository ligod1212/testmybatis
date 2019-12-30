package com.test.dao;

import com.test.domain.User;

import java.util.List;

/**
 * zl
 * 2019/12/24
 **/
public interface IUserDao {

   // @Select("select * from user ")
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userID
     * @return
     */
    User findById(Integer userID);

    /**
     * 根据名称模糊查询用户
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     *查询用户数
     * @return
     */
    int findTotal();
}

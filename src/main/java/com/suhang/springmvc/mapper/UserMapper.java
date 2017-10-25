package com.suhang.springmvc.mapper;

import com.suhang.springmvc.po.User;

/**
 * @author hang.su
 * @since 2017-09-28 9:58
 */

public interface UserMapper {

    public User findUserById(int id)throws Exception;
}


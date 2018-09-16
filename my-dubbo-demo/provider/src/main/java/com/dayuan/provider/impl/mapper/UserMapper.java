package com.dayuan.provider.impl.mapper;

import com.dayuan.provider.impl.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    User selectByCardNo(String loginName);
}
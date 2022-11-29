package com.elcome.plus.advmobifone.dao;

import com.elcome.plus.advmobifone.entity.User;

public interface UserDao {
    User findById(Long id);
}

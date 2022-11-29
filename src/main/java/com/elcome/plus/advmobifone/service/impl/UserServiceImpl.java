package com.elcome.plus.advmobifone.service.impl;

import com.elcome.plus.advmobifone.common.Response;
import com.elcome.plus.advmobifone.dao.UserDao;
import com.elcome.plus.advmobifone.entity.User;
import com.elcome.plus.advmobifone.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Response getUserInfo(Long id) {
        Response response = new Response();
        logger.info("get-user ===> start process ==========");
        User user = userDao.findById(id);
        if (Objects.isNull(user)) {
            logger.info("get-user ===> User not exists ==========");
            response.setCode(1);
            response.setMessage("Tài khoản không tồn tại.");
            return response;
        }
        response.setCode(0);
        response.setMessage("Lấy dữ liệu user thành công.");
        response.setData(user);
        logger.info("get-user ===> Get user info done ==========");
        return response;
    }
}

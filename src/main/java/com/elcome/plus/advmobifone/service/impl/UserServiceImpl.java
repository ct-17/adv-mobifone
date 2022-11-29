package com.elcome.plus.advmobifone.service.impl;

import com.elcome.plus.advmobifone.common.Response;
import com.elcome.plus.advmobifone.controller.UserController;
import com.elcome.plus.advmobifone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public Response getUserInfo(Long id) {
        Response response = new Response();
        return response;
    }
}

package com.elcome.plus.advmobifone.service;

import com.elcome.plus.advmobifone.common.Response;
import com.elcome.plus.advmobifone.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface UserService {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    Response getUserInfo(Long id);
}

package com.elcome.plus.advmobifone.controller;
import com.elcome.plus.advmobifone.common.Response;
import com.elcome.plus.advmobifone.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/api/users")
@AllArgsConstructor
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private UserService userService;

    @GetMapping
    public ResponseEntity<Response> getUserProfile(@RequestHeader(value = "id") String id) {
        logger.info("login ===> [{}] ========== GET API: /rest/api/users ==========", "0396745838");
        logger.info("login ===> id: {}", id);
        return ResponseEntity.ok(userService.getUserInfo(Long.valueOf(id)));
    }
}

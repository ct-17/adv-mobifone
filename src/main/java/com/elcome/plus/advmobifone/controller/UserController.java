package com.elcome.plus.advmobifone.controller;
import com.elcome.plus.advmobifone.common.Response;
import com.elcome.plus.advmobifone.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/api/users")
@AllArgsConstructor
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @GetMapping
    public ResponseEntity<Response> getUserProfile(@RequestHeader(value = "id") Long id) {
        logger.info("[{}] ========== GET API: /rest/api/users ==========", "0396745838");
        return ResponseEntity.ok(userService.getUserInfo(id));
    }
}

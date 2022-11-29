package com.elcome.plus.advmobifone.entity;

import com.elcome.plus.advmobifone.dto.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractResponse {
    private Long id;
    private String username;
    private String password;
    private String phone;
}

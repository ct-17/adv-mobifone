package com.elcome.plus.advmobifone.common;

import com.elcome.plus.advmobifone.dto.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int code;
    private String message;
    private AbstractResponse data;

    public Response(AbstractResponse data) {
        this.code = 0;
        this.message = "SUCCESS";
        this.data = data;
    }
    public Response() {
        this.code = 999;
        this.message = "Hệ thống hiện đang bận, vui lòng quay lại sau ít phút.";
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
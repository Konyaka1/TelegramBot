package com.telegram.bot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int status;

    private Object obj;

    private String msg;

    public static Response setError(String msg){
        return new Response(500, null, msg);
    }

    public static Response setSuccess(Object data){
        return new Response(200, data, "success");
    }
}

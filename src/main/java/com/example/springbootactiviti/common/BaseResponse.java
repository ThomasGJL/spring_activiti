package com.example.springbootactiviti.common;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private int status;
    private String msg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public BaseResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static BaseResponse success(){
        BaseResponse<Object> response = new BaseResponse<>();
        response.setStatus(0);
        response.setMsg("success");
        return response;
    }

    public static <T> BaseResponse<T> success(T data){
        BaseResponse success = success();
        success.setData(data);
        return success;
    }

    public static BaseResponse error(String msg){
        BaseResponse<Object> response = new BaseResponse<>();
        response.setStatus(-1);
        response.setMsg(msg);
        return response;
    }

}

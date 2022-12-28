package com.example.springbootactiviti.config;

import com.example.springbootactiviti.common.BaseResponse;
import org.activiti.engine.ActivitiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    public BaseResponse nullPointException(NullPointerException e)
    {
        return BaseResponse.error("系统错误");
    }

    @ExceptionHandler(ActivitiException.class)
    public BaseResponse activitiException(ActivitiException exception){
        return BaseResponse.error(exception.getLocalizedMessage());
    }

}

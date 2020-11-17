package com.xiaobao.food.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String  exception(Exception e){
        log.error(e.getMessage());
        return "出错了";
    }

}

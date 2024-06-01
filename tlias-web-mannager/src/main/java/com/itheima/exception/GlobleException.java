package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobleException {
    @ExceptionHandler(DuplicateKeyException.class)
    public Result exception(DuplicateKeyException e) {
        log.info("用户输入违反数据库唯一性");
        if (e.getMessage().contains("phone")) return Result.error("手机号重复");
        return Result.error("数据库错误，请反馈，谢谢");
    }
//只要违反了数据库的唯一性约束，Spring框架就会抛出DuplicateKeyException。
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error("新错误，请联系管理员");
    }


    @ExceptionHandler
    public Result exception(BussinessException e) {
        log.info(e+"");
        return Result.error(e.getMessage());
    }

}

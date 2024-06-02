package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result exception(DataIntegrityViolationException e){
        log.info("用户输入超出范围");
        return Result.error("数值过大，请重新输入");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result exception(MethodArgumentTypeMismatchException e) {
        log.info("用户输入的值不正确");
        return Result.error("您输入的值不正确，请重新输入");
    }
    @ExceptionHandler
    public Result exception(BussinessException e) {
        log.info(e + "");
        return Result.error(e.getMessage());
    }

}

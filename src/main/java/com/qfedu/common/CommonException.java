package com.qfedu.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * @description
 * @className: CommonException
 * @package: com.qfedu.common
 * @author: Stephen Shen
 * @date: 2020/9/10 下午2:15
 */
//控制器增强
//也需要扫描
@ControllerAdvice
@ResponseBody
public class CommonException {

    //修饰方法，表示一个异常处理的方法 返回一个json数据 {code:0 info：“账号不可为空”}
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult ConstraintViolationException(ConstraintViolationException ex){
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message="";
        if (iterator .hasNext()) {
            message = iterator.next().getMessage();
        }

        return new JsonResult(0, message);
    }

    //处理哪些没有意料到的异常
    @ExceptionHandler
    public JsonResult commonException(Exception ex){
        return new JsonResult(0,ex.getMessage());
    }

}

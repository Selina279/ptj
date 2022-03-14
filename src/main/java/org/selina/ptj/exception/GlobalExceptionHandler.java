package org.selina.ptj.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.selina.ptj.bean.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @ Author : Selina
 * @ Date : 2020/4/26
 * @ Description : org.selina.ptj.exception
 * @ version : 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if(e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}

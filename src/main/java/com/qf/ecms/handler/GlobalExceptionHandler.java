package com.qf.ecms.handler;

import com.qf.ecms.exception.DaoException;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.ws.Service;

/**
 * 两个注解
 * 在类上面使用 @RestControllerAdvice
 * 在方法上面使用 ExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(DaoException ex) {
        return ResponseEntity.error(ErrorStatus.SYS_ERROR);
    }

    @ExceptionHandler(DaoException.class)
    public String handlerDaoException(DaoException ex) {
        return ex.getMsg();
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity handlerServiceException(ServiceException ex) {
        return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
    }
}

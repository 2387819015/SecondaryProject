package com.example.secondaryproject.exception;

import com.example.secondaryproject.vo.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @Autowired
    private result result;

    @ExceptionHandler(XmException.class)
    public result handleException(XmException e){
        ExceptionEnum em = e.getExceptionEnum();
        result.fail(em.getCode() + "", em.getMsg());
        return result;
    }
}

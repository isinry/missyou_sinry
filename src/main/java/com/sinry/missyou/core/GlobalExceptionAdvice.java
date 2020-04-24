package com.sinry.missyou.core;

import com.sinry.missyou.core.configurations.ExceptionCodeConfiguration;
import com.sinry.missyou.exceptions.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codes;

    @ResponseBody
    @ExceptionHandler({Exception.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException (HttpServletRequest req, Exception e) {
        return this.getDiySimpleResponse(req, codes.getMessage(9999), 9999);
    }

    @ResponseBody
    @ExceptionHandler({HttpException.class})
    public ResponseEntity<UnifyResponse> handleHttpException (HttpServletRequest req, HttpException e) {
        return this.getDiyResponse(req, e.getMessage(), e.getCode(), e.getHttpStatusCode());
    }

    @ResponseBody
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanException (HttpServletRequest req, BindException e) {
        List<ObjectError> errors = e.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        errors.forEach(err -> stringBuilder.append(err.getDefaultMessage()).append(";"));
        return this.getDiySimpleResponse(req, stringBuilder.toString(), 10001);
    }

    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintException (HttpServletRequest req, ConstraintViolationException e) {
        StringBuilder stringBuilder = new StringBuilder();
        e.getConstraintViolations().forEach(err -> stringBuilder.append(err.getMessage()).append(";"));
        return this.getDiySimpleResponse(req, stringBuilder.toString(), 10001);
    }

    @ResponseBody
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleArgumentException (HttpServletRequest req, MethodArgumentTypeMismatchException e) {
        return this.getDiySimpleResponse(req, codes.getMessage(10001), 10001);
    }

    private UnifyResponse getDiySimpleResponse (HttpServletRequest req, String message, int code) {
        String request = req.getMethod() + " " + req.getRequestURI();
        return new UnifyResponse(code, message, request);
    }
    private ResponseEntity<UnifyResponse> getDiyResponse (HttpServletRequest req, String message, int code, int httpStatusCode) {
        String request = req.getMethod() + " " + req.getRequestURI();
        UnifyResponse unifyResponse = new UnifyResponse(code, message, request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(httpStatusCode);
        return new ResponseEntity<>(unifyResponse, headers, httpStatus);
    }
}

package com.sinry.missyou.exceptions.http;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HttpException extends RuntimeException {
    protected int code;
    protected String message;
    protected int httpStatusCode = 500;
}

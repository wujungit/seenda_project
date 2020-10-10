package com.seenda.basic.common.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success;

    private T content;

    private String message;

    private Integer code;

    public BaseResult() {
    }

    public BaseResult(T content) {
        this.content = content;
        success = true;
    }

    public BaseResult(Boolean success) {
        this.success = success;
    }

    public BaseResult(int code, String message) {
        this.message = message;
        this.code = code;
        success = false;
    }

    public BaseResult(Boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public BaseResult(Boolean success, int code, String message) {
        this.message = message;
        this.code = code;
        this.success = success;
    }

    public BaseResult(Boolean success, T content, int code, String message) {
        this.message = message;
        this.code = code;
        this.content = content;
        this.success = success;
    }

    public BaseResult<T> success(String message) {
        this.setSuccess(true);
        this.setMessage(message);
        return this;
    }

    public BaseResult<T> failure(String message) {
        this.setSuccess(false);
        this.setMessage(message);
        return this;
    }

    public void content(T t) {
        this.setContent(t);
    }

    public BaseResult<T> code(int code) {
        this.setCode(code);
        return this;
    }

    public BaseResult<T> successContent(T t) {
        this.content(t);
        this.success = true;
        return this;
    }

    public BaseResult(Boolean success, T content) {
        this.success = success;
        this.content = content;
    }

    public static BaseResult buildSuccess(String message, Object data) {
        return build(Boolean.TRUE, message, data);
    }

    public static BaseResult buildFailure(String message, Object data) {
        return build(Boolean.FALSE, message, data);
    }

    public static BaseResult build(Boolean success, String msg, Object data) {
        return build(success, msg, 0, data);
    }

    public static BaseResult build(Boolean success, String message, Integer code, Object data) {
        return new BaseResult(success, data, code, message);
    }

}

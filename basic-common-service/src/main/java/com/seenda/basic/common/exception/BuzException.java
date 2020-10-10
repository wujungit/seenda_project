package com.seenda.basic.common.exception;


import com.seenda.basic.common.enums.ResultEnum;
import lombok.Getter;

@Getter
public class BuzException extends RuntimeException {

    private final Integer code;

    public BuzException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BuzException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}

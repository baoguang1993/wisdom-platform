package com.libaoguang.cn.principlecommon.exception;


import com.libaoguang.cn.principlecommon.enums.ResultEnum;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private Integer code;
    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}

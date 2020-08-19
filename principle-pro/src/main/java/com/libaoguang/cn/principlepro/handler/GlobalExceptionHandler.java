package com.libaoguang.cn.principlepro.handler;

import com.libaoguang.cn.principlecommon.vo.ResultVo;
import com.libaoguang.cn.principlecommon.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handle(Exception e) {
        ResultVo resultVo;
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            resultVo = ResultVo.failResult(baseException);
            return resultVo;
        } else {
            resultVo = ResultVo.unknownResult(e.getMessage());
            return resultVo;
        }
    }
}

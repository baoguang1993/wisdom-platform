package com.libaoguang.cn.principlepro.handler;


import com.libaoguang.cn.principlepro.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public ResultVo requrnValue(ProceedingJoinPoint proceedingJoinPoint) {
        ResultVo resultVo;
        try {
            resultVo = (ResultVo) proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("GlobalExceptionHandler system error {}:" + throwable);
            resultVo = ResultVo.failResult();
        }
        return resultVo;
    }
}
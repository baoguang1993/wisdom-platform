package com.libaoguang.cn.principlepro.vo;

import java.io.Serializable;

public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 信息描述
     */
    public static final String MESSAGE_SUCCESS = "操作成功";
    public static final String MESSAGE_FAIL = "操作成功";
    /**
     * 调用结果
     */

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAIL = "fail";
    /**
     * code标识
     */
    public static final String CODE_SUCCESS = "sys_fail";
    public static final String CODE_FAIL = "sys_success";

    private String code;
    private String message;
    private String result;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResultVo successResult() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CODE_SUCCESS);
        resultVo.setMessage(MESSAGE_SUCCESS);
        resultVo.setResult(RESULT_SUCCESS);
        return resultVo;
    }
    public static ResultVo successResult(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CODE_SUCCESS);
        resultVo.setMessage(MESSAGE_SUCCESS);
        resultVo.setResult(RESULT_SUCCESS);
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVo failResult() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CODE_FAIL);
        resultVo.setMessage(MESSAGE_FAIL);
        resultVo.setResult(RESULT_FAIL);
        return resultVo;
    }
    public static ResultVo failResult(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CODE_FAIL);
        resultVo.setMessage(message);
        resultVo.setResult(RESULT_FAIL);
        return resultVo;
    }
    public static ResultVo failResult(String code,String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        resultVo.setResult(RESULT_FAIL);
        return resultVo;
    }
}

package com.exception;


public abstract class BaseException extends RuntimeException{
    private String errorMsg;
    private Object[] paramList;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object[] getParamList() {
        return paramList;
    }

    public void setParamList(Object[] paramList) {
        this.paramList = paramList;
    }
}

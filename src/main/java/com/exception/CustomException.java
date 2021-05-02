package com.exception;

public class CustomException extends BaseException{

    @Override
    public String getErrorMsg() {
        return super.getErrorMsg();
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        super.setErrorMsg(errorMsg);
    }

    @Override
    public Object[] getParamList() {
        return super.getParamList();
    }

    @Override
    public void setParamList(Object[] paramList) {
        super.setParamList(paramList);
    }
}

package com.util;

import com.exception.CustomException;

import java.util.Collection;

public class Utils {
    public static boolean isNullOrEmpty( String str ) {
        return null == str || "".equals(str);
    }

    public static boolean objIsEmpty( Object object ) {
        return object == null;
    }

    public static boolean isEmpty( Collection collection ) {
        return collection == null || collection.size() == 0;
    }

    public static void getCustomException( String i18n, Object[] objects ) {
        CustomException exception = new CustomException();
        exception.setErrorMsg(i18n);
        exception.setParamList(objects);
        throw exception;
    }

    public static void getCustomException( String i18n ) {
        CustomException exception = new CustomException();
        exception.setErrorMsg(i18n);
        throw exception;
    }
}

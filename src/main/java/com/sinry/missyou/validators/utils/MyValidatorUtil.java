package com.sinry.missyou.validators.utils;

public class MyValidatorUtil {

    public static boolean isNotEmpty (Object o) {
        return !(o == null || "".equals(o));
    }
    public static boolean isEqualNotEmpty (Object o) {
        return isNotEmpty(o) || !Integer.valueOf(0).equals(o) || !"0".equals(o);
    }
}

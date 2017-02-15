package com.example.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * log4jを使用する為のUtil
 */
public class ZacLogUtil {
    static Log log = LogFactory.getLog(ZacLogUtil.class);

    private ZacLogUtil() {
    }

    public static Log getLog() {
        return log;
    }

    public static String logFormat(String className, String methodName) {
        String str ="class name:[" + className + "]" + "Method Name:[" + methodName + "]";
        return str;
    }
}

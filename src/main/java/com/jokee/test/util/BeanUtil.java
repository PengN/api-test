package com.jokee.test.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

public class BeanUtil {
    public static Object forName(String fullClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(fullClassName);
        return aClass.newInstance();
    }
    public static Object forNameAndSetValue(String fullClassName, String objJson) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object o = forName(fullClassName);
        JSONObject jsonObject = JSONObject.parseObject(objJson);
        BeanUtils.copyProperties(jsonObject, o);
        return o;
    }
    public static void setValue(Object param, String objJson) {
        JSONObject jsonObject = JSONObject.parseObject(objJson);
        BeanUtils.copyProperties(jsonObject, param);
    }
    public static Object getParam(Class<?> paramType, String objJson) {
        return JSONObject.parseObject(objJson, paramType);
    }

    public static Object setSimpleTypeValue(Class type, String simpleTypeValue) throws IllegalAccessException, InstantiationException {
        switch (type.getName()) {
            case "int" :
            case "java.lang.Integer" :
                return Integer.parseInt(simpleTypeValue);
            case "long" :
            case "java.lang.Long" :
                return Long.parseLong(simpleTypeValue);
            case "double" :
            case "java.lang.Double" :
                return Double.parseDouble(simpleTypeValue);
            case "float" :
            case "java.lang.Float" :
                return Float.parseFloat(simpleTypeValue);
            case "boolean" :
            case "java.lang.Boolean" :
                return Boolean.parseBoolean(simpleTypeValue);
            case "java.lang.String" :
                return simpleTypeValue;
            default: break;
        }
        return null;
    }
}

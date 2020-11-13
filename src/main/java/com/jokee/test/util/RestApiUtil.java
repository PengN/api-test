package com.jokee.test.util;

import com.jokee.test.vo.RestCallReq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class RestApiUtil {
    public static final Map<String, Class> SIMPLE_TYPE_MAP = new HashMap<>(8);
    static {
        SIMPLE_TYPE_MAP.put("int", int.class);
        SIMPLE_TYPE_MAP.put("double", double.class);
//        SIMPLE_TYPE_MAP.put("byte", byte.class);
//        SIMPLE_TYPE_MAP.put("short", short.class);
//        SIMPLE_TYPE_MAP.put("char", char.class);
        SIMPLE_TYPE_MAP.put("boolean", boolean.class);
        SIMPLE_TYPE_MAP.put("float", float.class);
        SIMPLE_TYPE_MAP.put("long", long.class);
        SIMPLE_TYPE_MAP.put("String", String.class);
    }
    public static Object[] setInvokeParam(Class[] paramFullClassNameList, List<String> paramObjJsonList) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (ArrayUtils.isEmpty(paramFullClassNameList)) {
            return null;
        }
        int paramValueSize = 0;
        if (CollectionUtils.isNotEmpty(paramObjJsonList)) {
            paramValueSize = paramObjJsonList.size();
        }
        Object[] args = new Object[paramFullClassNameList.length];
        for (int i = 0; i < paramFullClassNameList.length; i++) {
            Class fullClassName = paramFullClassNameList[i];
            String objJson = getObjJson(paramObjJsonList, paramValueSize, i);

            Object param = setParamValue(objJson, fullClassName);
            args[i] = param;
        }
        return args;
    }

    private static String getObjJson(List<String> paramObjJsonList, int paramValueSize, int i) {
        if (paramValueSize == 0 || paramValueSize <= i) {
            return null;
        }
        return paramObjJsonList.get(i);
    }

    private static Object setParamValue(String objJson, Class cls) throws IllegalAccessException, InstantiationException {
        if (StringUtils.isBlank(objJson)) {
            return null;
        }
            // 简单类型直接赋值 复杂类型JSONObject.parse
        return SIMPLE_TYPE_MAP.values().contains(cls) ? BeanUtil.setSimpleTypeValue(cls, objJson)
                : BeanUtil.getParam(cls, objJson);
    }

    public static Object invoke(Object bean, Method declaredMethod, Object[] objects) throws InvocationTargetException, IllegalAccessException {
        if (ArrayUtils.isEmpty(objects)) {
            return declaredMethod.invoke(bean);
        }
        return declaredMethod.invoke(bean, objects);
    }

    public static Class[] getParamTypeList(List<String> paramFullClassNameList) throws ClassNotFoundException {
        if (CollectionUtils.isEmpty(paramFullClassNameList)) {
            return null;
        }
        Class[] classes = new Class[paramFullClassNameList.size()];
        for (int i = 0; i < paramFullClassNameList.size(); i++) {
            String className = paramFullClassNameList.get(i);
            if (SIMPLE_TYPE_MAP.keySet().contains(className)) {
                classes[i] = SIMPLE_TYPE_MAP.get(className);
            }
            else {
                classes[i] = Class.forName(className);
            }
        }
        return classes;
    }

    public static Method getMethod(Class<?> cls, String method, Class[] paramTypeList) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Method invokeMethod = null;
        for (Method declaredMethod : declaredMethods) {
            if (method.equals(declaredMethod.getName())) {
                int parameterCount = declaredMethod.getParameterCount();
                if (parameterCount == paramTypeList.length) {
                    Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                    boolean isMatch = true;
                    for (int i = 0; i < parameterTypes.length; i++) {
                        String typeName = parameterTypes[i].getTypeName();
                        String paramTypeName = paramTypeList[i].getTypeName();
                        if (!typeName.equals(paramTypeName)) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        invokeMethod = declaredMethod;
                        break;
                    }
                }
            }
        }
        return invokeMethod;
    }

    public static Object invoke(Object bean, RestCallReq restCallReq) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class[] paramTypeList = RestApiUtil.getParamTypeList(restCallReq.getParamFullClassNameList());

        assert bean != null;
        Method method = RestApiUtil.getMethod(bean.getClass(), restCallReq.getMethod(), paramTypeList);
        assert method != null;
        System.out.println(method.getParameterTypes().length);
        Object[] objects = RestApiUtil.setInvokeParam(paramTypeList, restCallReq.getParamObjectJsonList());
        System.out.println(objects.length);
        return RestApiUtil.invoke(bean, method, objects);
    }
}

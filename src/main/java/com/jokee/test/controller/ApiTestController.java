package com.jokee.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jokee.test.service.impl.TestServiceImpl;
import com.jokee.test.util.RestApiUtil;
import com.jokee.test.util.SpringBeanUtil;
import com.jokee.test.vo.Classes;
import com.jokee.test.vo.RestCallReq;
import com.jokee.test.vo.School;
import com.jokee.test.vo.Student;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class ApiTestController {
    @PostMapping("callService")
    public Object callService(@RequestBody RestCallReq restCallReq) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object bean = SpringBeanUtil.getBeanByName(restCallReq.getServiceName());
        assert bean != null;
        return RestApiUtil.invoke(bean, restCallReq);
    }
    @PostMapping("callController")
    public Object callController(@RequestBody RestCallReq restCallReq) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object bean = SpringBeanUtil.getBeanByName(restCallReq.getServiceName());
        assert bean != null;
        return RestApiUtil.invoke(bean, restCallReq);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        testInvoke();
//        Class<TestServiceImpl> cls = TestServiceImpl.class;
//        Class<Integer> integerClass = int.class;
//        Class<Integer> integerClass1 = Integer.class;
//        Method testRestApiService = RestApiUtil.getMethod(cls, "testRestApiService", new Class[]{List.class, String.class, String.class, String.class});
//        Class<String> stringClass = String.class;
//        String s = stringClass.newInstance();
//        JSONObject jsonObject = new JSONObject();
//        RestCallReq restCallReq = new RestCallReq();
//        restCallReq.setMethod("method");
//        restCallReq.setServiceName("service");
//        List<RestCallReq> lsit = new ArrayList<>();
//        lsit.add(restCallReq);
//        Object param = BeanUtil.getParam(List.class, JSONObject.toJSONString(lsit));
//        Object invoke = testRestApiService.invoke(cls.newInstance(), param, "3", "3", "4");
//        System.out.println(invoke);
//
//        List list = JSONObject.parseObject(JSONObject.toJSONString(lsit), List.class);
//        List<RestCallReq> objects = JSONObject.parseArray(JSONObject.toJSONString(lsit), RestCallReq.class);
//        System.out.println(list);
//        System.out.println(objects);
//        Class<String[]> aClass = String[].class;
//        String typeName = aClass.getTypeName();
//        System.out.println(typeName);
//        Class<RestCallReq[]> aClass1 = RestCallReq[].class;
////        Classes.forName("com.jokee.test.vo.RestCallReq[]")
//        System.out.println(aClass1.getTypeName());
//        Class<?> aClass2 = Class.forName("[Lcom.jokee.test.vo.RestCallReq;");
//        System.out.println(aClass2.getTypeName());
//        Object o = JSONObject.parseObject(JSONObject.toJSONString(lsit), aClass2);
//        System.out.println(o.getClass());
//        System.out.println(JSONObject.toJSONString(o));
//        Class<Integer> integer = int.class;
////        Method parseInteger = integer.getDeclaredMethod("parseInt", String.class);
////        Object invoke1 = parseInteger.invoke(null, "2");
//        System.out.println(Integer.class.getName());
//        System.out.println(Double.class.getName());
//        System.out.println(BigDecimal.class.getName());
//        RestApiUtil.SIMPLE_TYPE_MAP.values().forEach(item -> System.out.println(item.getName()));
    }

    private static void testInvoke() throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        Student student = new Student(12, "xiao hei", "男");
        Student student1 = new Student(13, "xiao hong", "女");
        Classes classes = new Classes("一班", new ArrayList<>(Lists.newArrayList(student)));
        Classes classes1 = new Classes("二班", new ArrayList<>(Lists.newArrayList(student1)));
        School school = new School(Lists.newArrayList(classes, classes1), "s1");
//        Classes classes, School school, Student student, String arg4, int a, boolean b, Long c
        RestCallReq restCallReq = new RestCallReq();
        restCallReq.setMethod("testRestApiService");
        restCallReq.setParamFullClassNameList(Lists.newArrayList());
        restCallReq.setParamObjectJsonList(Lists.newArrayList());
        restCallReq.getParamObjectJsonList().add(JSONObject.toJSONString(classes));
        restCallReq.getParamObjectJsonList().add(JSONObject.toJSONString(school));
        restCallReq.getParamObjectJsonList().add(JSONObject.toJSONString(student));
        restCallReq.getParamObjectJsonList().add("String value");
        restCallReq.getParamObjectJsonList().add("1111");
        restCallReq.getParamObjectJsonList().add("false");
        restCallReq.getParamObjectJsonList().add("13318977");
        restCallReq.getParamFullClassNameList().add("com.jokee.test.vo.Classes");
        restCallReq.getParamFullClassNameList().add("com.jokee.test.vo.School");
        restCallReq.getParamFullClassNameList().add("com.jokee.test.vo.Student");
        restCallReq.getParamFullClassNameList().add("java.lang.String");
        restCallReq.getParamFullClassNameList().add("int");
//        restCallReq.getParamFullClassNameList().add("java.lang.Integer");
        restCallReq.getParamFullClassNameList().add("boolean");
        restCallReq.getParamFullClassNameList().add("java.lang.Long");
        List<Object> objects = TestServiceImpl.testRestApiService(classes, school, student, "", 111, false, 1231223L);

        System.out.println(JSONObject.toJSONString(restCallReq));

        Object invoke = RestApiUtil.invoke(TestServiceImpl.class.newInstance(), restCallReq);
        System.out.println(invoke);
    }
}

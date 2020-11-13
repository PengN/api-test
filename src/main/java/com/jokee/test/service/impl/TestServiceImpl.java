package com.jokee.test.service.impl;

import com.jokee.test.service.TestService;
import com.jokee.test.vo.Classes;
import com.jokee.test.vo.RestCallReq;
import com.jokee.test.vo.School;
import com.jokee.test.vo.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public List<Object> testRestApiService(String arg1, int arg2, String arg3, String arg4) {
        System.out.println("2int");
        List<Object> result = new ArrayList<>();
        result.add(arg1);
        result.add(arg2);
        result.add(arg3);
        result.add(arg4);

        return result;
    }
    @Override
    public List<Object> testRestApiService(int arg1, String arg2, String arg3, String arg4) {
        System.out.println("1 int");
        List<Object> result = new ArrayList<>();
        result.add(arg1);
        result.add(arg2);
        result.add(arg3);
        result.add(arg4);

        return result;
    }
    public List<Object> testRestApiService(List<RestCallReq> arg1, String arg2, String arg3, String arg4) {
        System.out.println("integer list");
        List<Object> result = new ArrayList<>();
        result.add(arg1);
        result.add(arg2);
        result.add(arg3);
        result.add(arg4);

        return result;
    }
    public List<Object> testRestApiService(String[] arg1, String arg2, String arg3, String arg4) {
        System.out.println("long list");
        List<Object> result = new ArrayList<>();
        result.add(arg1);
        result.add(arg2);
        result.add(arg3);
        result.add(arg4);

        return result;
    }
    public static List<Object> testRestApiService(Classes classes, School school, Student student, String arg4) {
        List<Object> result = new ArrayList<>();
        result.add(classes);
        result.add(school);
        result.add(school);
        result.add(arg4);

        return result;
    }
    public static List<Object> testRestApiService(Classes classes, School school, Student student, String arg4, int a, boolean b, Long c) {
        List<Object> result = new ArrayList<>();
        result.add(classes);
        result.add(school);
        result.add(school);
        result.add(arg4);
        result.add(a);
        result.add(c);
        result.add(b);

        return result;
    }
    public static List<Object> testRestApiService(Classes classes, School school, Student student, String arg4, int a, boolean b) {
        List<Object> result = new ArrayList<>();
        result.add(classes);
        result.add(school);
        result.add(school);
        result.add(arg4);
        result.add(a);
        result.add(b);

        return result;
    }
    public static List<Object> testRestApiService(Classes classes, School school, Student student, String arg4, Integer a) {
        List<Object> result = new ArrayList<>();
        result.add(classes);
        result.add(school);
        result.add(school);
        result.add(arg4);
        result.add(a);

        return result;
    }
}

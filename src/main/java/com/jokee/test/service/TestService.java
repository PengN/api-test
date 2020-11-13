package com.jokee.test.service;

import com.jokee.test.vo.Classes;
import com.jokee.test.vo.School;
import com.jokee.test.vo.Student;
import java.util.List;

public interface TestService {
    List<Object> testRestApiService(String arg1, int arg2, String arg3, String arg4);
    List<Object> testRestApiService(int arg1, String arg2, String arg3, String arg4);

}

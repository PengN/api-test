package com.jokee.test.vo;

import java.util.List;

public class Classes {
    private String classesName;
    private List<Student> studentList;

    public Classes(String classesName, List<Student> studentList) {
        this.classesName = classesName;
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classesName='" + classesName + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

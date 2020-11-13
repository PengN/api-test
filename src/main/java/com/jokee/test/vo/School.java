package com.jokee.test.vo;

import java.util.List;

public class School {
    private List<Classes> classesList;
    private String schoolName;

    public School(List<Classes> classesList, String schoolName) {
        this.classesList = classesList;
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "classesList=" + classesList +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}

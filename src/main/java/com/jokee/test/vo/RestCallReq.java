package com.jokee.test.vo;

import java.util.List;

public class RestCallReq {
    private String serviceName;
    private String method;
    private List<String> paramObjectJsonList;
    private List<String> paramFullClassNameList;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<String> getParamObjectJsonList() {
        return paramObjectJsonList;
    }

    public void setParamObjectJsonList(List<String> paramObjectJsonList) {
        this.paramObjectJsonList = paramObjectJsonList;
    }

    public List<String> getParamFullClassNameList() {
        return paramFullClassNameList;
    }

    public void setParamFullClassNameList(List<String> paramFullClassNameList) {
        this.paramFullClassNameList = paramFullClassNameList;
    }

    @Override
    public String toString() {
        return "RestCallReq{" +
                "serviceName='" + serviceName + '\'' +
                ", method='" + method + '\'' +
                ", paramObjectJsonList=" + paramObjectJsonList +
                ", paramFullClassNameList=" + paramFullClassNameList +
                '}';
    }
}

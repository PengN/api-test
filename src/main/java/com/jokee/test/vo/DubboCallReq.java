package com.jokee.test.vo;

import java.util.List;

public class DubboCallReq {
    private String address;
    private String group;
    private String protocol;
    private String interfaceName;
    private String method;
    private List<String> reqParamFullClassName;
    private List<Object> reqParamValue;

    public List<String> getReqParamFullClassName() {
        return reqParamFullClassName;
    }

    public void setReqParamFullClassName(List<String> reqParamFullClassName) {
        this.reqParamFullClassName = reqParamFullClassName;
    }

    public List<Object> getReqParamValue() {
        return reqParamValue;
    }

    public void setReqParamValue(List<Object> reqParamValue) {
        this.reqParamValue = reqParamValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

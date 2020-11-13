package com.jokee.test.util;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

public class DubboUtil {
    public static GenericService getInvokeService(String group, String adress, String protocol, String interfaceName) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("CRM_IC");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(adress);
        registry.setProtocol(protocol);
        registry.setGroup(group);

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(application);
        referenceConfig.setRegistry(registry);
//        referenceConfig.setGroup(group);
        referenceConfig.setGeneric(true);
        referenceConfig.setInterface(interfaceName);
        return referenceConfig.get();
    }
    public static GenericService getInvokeService1(String group, String adress, String protocol, String interfaceName) {
        //设置默认超时无限制,用于在本地调试的时候用
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setTimeout(Integer.MAX_VALUE);
        referenceConfig.setApplication(new ApplicationConfig("CRM_IC"));
        referenceConfig.setInterface(interfaceName);
//        referenceConfig.setGroup(group);

        //通过zk访问
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(adress);
        registry.setProtocol(protocol);
        registry.setGroup(group);
        referenceConfig.setRegistry(registry);

//        referenceConfig.setVersion(request.getVersion());
        referenceConfig.setGeneric(true);
        //hard code
        referenceConfig.setRetries(1);
        return referenceConfig.get();
    }
}

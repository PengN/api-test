package com.jokee.test.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSONObject;
import com.jokee.test.util.DubboUtil;
import com.jokee.test.vo.DubboCallReq;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class DubboTestController {

    @PostMapping("/callService")
    public Object callService(@RequestBody DubboCallReq req) {
        GenericService invokeService = DubboUtil.getInvokeService1(req.getGroup(), req.getAddress(),
                StringUtils.defaultString(req.getProtocol(), "zookeeper"), req.getInterfaceName());
        List<String> reqFullClassName = req.getReqParamFullClassName();
        Object result = invokeService.$invoke(req.getMethod(), reqFullClassName.toArray(new String[0]), req.getReqParamValue().toArray());
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        GenericService invokeService = DubboUtil.getInvokeService("dev_np", "192.168.60.1:2181", "zookeeper", "com.ztesoft.zsmart.bss.crm.ic.dubbo.goods.service.GmGoodsService");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("custId", 1027170);
        Object queryReserveGoods = invokeService.$invoke("queryReserveGoods", new String[]{"com.ztesoft.zsmart.bss.crm.ic.dubbo.goods.model.ReserveGoodsQueryReq"}, new Object[]{jsonObject});
        System.out.println(queryReserveGoods);
    }
}

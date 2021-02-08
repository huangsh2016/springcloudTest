package sun.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.client.ServiceFeignClient;
import sun.entity.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ServiceController {

    @Autowired
    ServiceFeignClient serviceFeignClient;

    // 调用：localhost:6004/consumerService?token=1
    @RequestMapping("/consumerService")
    public void consumerService(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody ServiceInfo serviceInfo){

        RestfulResult restfulResult =  serviceFeignClient.hello(serviceInfo);

        CommUtils.printDataJason(response, restfulResult);
    }
}
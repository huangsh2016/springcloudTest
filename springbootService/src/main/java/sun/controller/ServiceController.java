package sun.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.entity.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // 重要，如果用Controller会404
@RequestMapping(value = "service")
@Slf4j
public class ServiceController {

    private static Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @RequestMapping(value = "hello")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestBody ServiceInfo serviceInfo) {

        RestfulResult restfulResult = new RestfulResult();

        try {
            restfulResult.setData("Service1:Welcome " + serviceInfo.getName() + "!");
            log.info("22 Service1:Welcome " + serviceInfo.getName() + "!");
                logger.info("{} {} {} {}", "HTTP", "GET", "/api/test", "none");
                logger.info("{} {} {} {}", "HTTP", "POST", "/api/test", "天王盖地虎");
                logger.info("{} {} {}", "WS", "ChenFabao", "我已到达");
                logger.info("{} {} {} {}", "HTTP", "GET", "/api/test", "other");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CommUtils.printDataJason(response, restfulResult);
    }

    @RequestMapping(value = "rest")
    public String rest(@RequestBody ServiceInfo serviceInfo) {

        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }
}

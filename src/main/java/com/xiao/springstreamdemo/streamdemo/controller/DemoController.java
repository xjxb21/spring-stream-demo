package com.xiao.springstreamdemo.streamdemo.controller;

import com.xiao.springstreamdemo.streamdemo.CloudStreamDemo1_output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * Description:
 *
 * @author: xiaojixiang
 * @version: 1.0
 */
@RestController
public class DemoController {


    @Autowired
    @Qualifier("demo1Service")
    CloudStreamDemo1_output output;

    /**
     * cloudStreamDemo1 测试
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public String testDemo1(Integer num) {
        assert num > 0;
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < num; i++) {
                output.sayHello("xiaojixiang:::" + i);
            }
        })
                .whenComplete((BiConsumer) (o, o2) -> System.out.println("task completed !"));
        return "Task run successful!";
    }

}

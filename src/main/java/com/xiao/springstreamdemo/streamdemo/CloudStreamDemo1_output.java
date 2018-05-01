package com.xiao.springstreamdemo.streamdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Description: 启用绑定 IShop
 *
 * @author: xiaojixiang
 * @version: 1.0
 */

@EnableBinding(IShop.class)
@Component("demo1Service")
public class CloudStreamDemo1_output {

    private MessageChannel output;

    /**
     * myOutputCommodity 是ISop中 的输出channel的注解名字
     *
     * @param output
     */
    @Autowired
    public CloudStreamDemo1_output(@Qualifier("myOutputCommodity") MessageChannel output) {
        this.output = output;
    }

    public void sayHello(String name) {
        this.output.send(MessageBuilder.withPayload(name).build());
        System.out.println("send message ::: " + name);
    }
}

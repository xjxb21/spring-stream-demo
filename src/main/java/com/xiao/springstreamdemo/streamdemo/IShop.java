package com.xiao.springstreamdemo.streamdemo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Description:
 *
 * @author: xiaojixiang
 * @version: 1.0
 */
public interface IShop {
    /**
     * commodity 商品
     * myOutputCommodity 表示输出的通道名称
     *
     * @return
     */
    @Output("myOutputCommodity")
    MessageChannel commodity();
}

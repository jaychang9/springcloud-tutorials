package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;

/**
 *
 * <p>
 *  用于接受订单创建成功的消息 注意注意！这里用的收 Source哦
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-05
 */
@EnableBinding(Source.class)
public class OrderCreateResultMessageListener {

    @StreamListener(Source.OUTPUT)
    public void receive2(String msg) {
        System.out.println("msg:"+msg);
    }
}

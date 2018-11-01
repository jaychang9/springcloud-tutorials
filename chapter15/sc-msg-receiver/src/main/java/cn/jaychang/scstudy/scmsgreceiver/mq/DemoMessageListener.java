package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
@EnableBinding(Sink.class)
public class DemoMessageListener {
    @StreamListener(Sink.INPUT)
    public void input(String message) {
        System.out.println("Demo收到消息：" + message);
    }
}

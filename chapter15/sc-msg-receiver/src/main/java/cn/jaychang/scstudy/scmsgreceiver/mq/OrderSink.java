package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
public interface OrderSink {
    String INPUT_ORDER = "inputOrder";

    @Input(INPUT_ORDER)
    SubscribableChannel inputOrder();
}

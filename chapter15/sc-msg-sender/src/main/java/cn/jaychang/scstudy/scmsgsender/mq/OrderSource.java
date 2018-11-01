package cn.jaychang.scstudy.scmsgsender.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * <p>
 *  定义一个接口
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
public interface OrderSource {

    String OUTPUT_ORDER = "outputOrder";

    @Output(OrderSource.OUTPUT_ORDER)
    MessageChannel outputOrder();
}
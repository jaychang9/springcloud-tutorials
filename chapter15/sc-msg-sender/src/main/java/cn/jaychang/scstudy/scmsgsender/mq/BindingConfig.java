package cn.jaychang.scstudy.scmsgsender.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
@EnableBinding({Source.class,OrderSource.class})
public class BindingConfig {
}

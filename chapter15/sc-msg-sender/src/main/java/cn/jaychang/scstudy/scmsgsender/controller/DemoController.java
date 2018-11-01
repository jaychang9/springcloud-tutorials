package cn.jaychang.scstudy.scmsgsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */

@SuppressWarnings("AlibabaRemoveCommentedCode")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel output;


    @GetMapping("/01")
    public String sendMessage01(){
        boolean sendResult = output.send(MessageBuilder.withPayload("测试消息").build());
        return "发送结果："+sendResult;

    }
}

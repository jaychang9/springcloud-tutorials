package cn.jaychang.scstudy.scmsgsender.controller;

import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.http.HttpHeaderNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.RequestEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
        String payload = "测试消息"+new Random().nextInt(2);
        boolean sendResult = output.send(MessageBuilder.withPayload(payload).build());
        return "发送结果："+sendResult;

    }
}

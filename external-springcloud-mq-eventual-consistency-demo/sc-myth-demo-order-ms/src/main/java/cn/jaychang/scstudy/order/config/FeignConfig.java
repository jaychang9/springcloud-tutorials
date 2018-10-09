package cn.jaychang.scstudy.order.config;

import com.github.myth.springcloud.feign.MythFeignHandler;
import com.github.myth.springcloud.feign.MythRestTemplateInterceptor;
import feign.Feign;
import feign.InvocationHandlerFactory;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.config
 * @description 项目配置
 * @create 2018-10-07 14:42
 */
@Configuration
public class FeignConfig {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .requestInterceptor(new MythRestTemplateInterceptor())
                .invocationHandlerFactory(invocationHandlerFactory());
    }

    @Bean
    public InvocationHandlerFactory invocationHandlerFactory() {
        return (target, dispatch) -> {
            MythFeignHandler handler = new MythFeignHandler();
            handler.setTarget(target);
            handler.setHandlers(dispatch);
            return handler;
        };
    }

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(5000, 5000);
    }

    @Bean
    Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }
}

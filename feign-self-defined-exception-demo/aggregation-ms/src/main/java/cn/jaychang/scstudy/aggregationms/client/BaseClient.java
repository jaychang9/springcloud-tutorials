package cn.jaychang.scstudy.aggregationms.client;

import cn.jaychang.scstudy.aggregationms.config.FeignConfig;
import com.netflix.ribbon.hystrix.FallbackHandler;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 */
//如果要自定义处理下游服务调用异常，可以用configuration = FeignConfig.class
@FeignClient(name = "base-ms",fallbackFactory = BaseClientFallbackFactory.class,configuration = FeignConfig.class)
public interface BaseClient {
	@GetMapping("/base/hello1")
	// 一定要用@RequestParam注解，不然会发POST请求
	String hello1(@RequestParam("name") String name);

	//一定要用@RequestParam注解,不然会发POST请求
	@GetMapping("/base/hello2")
	String hello2(@RequestParam("name") String name);

}



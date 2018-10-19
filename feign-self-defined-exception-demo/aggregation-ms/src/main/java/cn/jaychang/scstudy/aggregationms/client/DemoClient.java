package cn.jaychang.scstudy.aggregationms.client;

import cn.jaychang.scstudy.aggregationms.config.FeignConfig;
import cn.jaychang.scstudy.aggregationms.dto.DemoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * <p>
 *	Demo Feign客户端
 * </p>
 *
 * @author zhangjie
 *
 * @date 2018-10-16 10:41
 */
@FeignClient(name = "peppa-demo", fallbackFactory = DemoClientFallbackFactory.class, configuration = FeignConfig.class)
@RequestMapping("/demo/demo")
public interface DemoClient {
	@GetMapping("/mockException/{id}")
	DemoDTO mockDetailThrowException(@PathVariable("id") Long id);

	@GetMapping("/{id}")
	DemoDTO detail(@PathVariable("id") Long id);
}


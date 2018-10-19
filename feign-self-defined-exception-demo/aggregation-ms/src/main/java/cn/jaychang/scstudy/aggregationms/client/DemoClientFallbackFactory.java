package cn.jaychang.scstudy.aggregationms.client;

import cn.jaychang.scstudy.aggregationms.dto.DemoDTO;
import org.springframework.stereotype.Component;


import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 如果是抛出的是HystrixBadRequestException不会进入熔断
 * 否则会进入熔断
 */
@Slf4j
@Component
public class DemoClientFallbackFactory implements FallbackFactory<DemoClient> {

	@Override
	public DemoClient create(Throwable throwable) {
		log.debug("进入熔断方法DemoClientFallbackFactory->create");
		return new DemoClient() {
			@Override
			public DemoDTO mockDetailThrowException(Long id) {
				return null;
			}

			@Override
			public DemoDTO detail(Long id) {
				return null;
			}
		};
	}
}

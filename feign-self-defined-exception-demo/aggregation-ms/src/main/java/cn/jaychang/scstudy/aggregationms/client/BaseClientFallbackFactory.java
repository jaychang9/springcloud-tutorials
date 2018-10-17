package cn.jaychang.scstudy.aggregationms.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 */
@Component
public class BaseClientFallbackFactory implements FallbackFactory<BaseClient> {

	@Override
	public BaseClient create(Throwable throwable) {
		System.out.println("BaseClientFallbackFactory.create "+throwable.getMessage()+throwable.getClass().getName());
		return new BaseClient() {
			@Override
			public String hello1(String name) {
				return "Fallback hello1";
			}

			@Override
			public String hello2(String name) {
				return "Fallback hello2";
			}
		};
	}
}

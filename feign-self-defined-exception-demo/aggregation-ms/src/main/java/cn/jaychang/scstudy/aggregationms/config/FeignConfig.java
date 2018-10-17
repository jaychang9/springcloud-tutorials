package cn.jaychang.scstudy.aggregationms.config;

import cn.jaychang.scstudy.aggregationms.dto.ExceptionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 */
@Configuration
public class FeignConfig {

	private final static ObjectMapper om = new ObjectMapper();

	/**
	 * 自定义feign调用的错误解码
	 *
	 * @return
	 */
	@Bean
	public ErrorDecoder errorDecoder(){
		return new ErrorDecoder() {
			@Override
			public Exception decode(String methodKey, Response response) {
				System.out.println(methodKey);
				try {
					String body = Util.toString(response.body().asReader());
					ExceptionDTO exceptionDTO = om.readValue(body, ExceptionDTO.class);
					// 如果返回的是HystrixBadRequestException，(开启了feign的hystrix则不会进入熔断方法,而是直接抛出)
					return new HystrixBadRequestException(exceptionDTO.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return new HystrixBadRequestException("Unkown error");
			}
		};
	}
}

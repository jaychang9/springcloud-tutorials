package cn.jaychang.scstudy.basems.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.jaychang.scstudy.basems.model.result.ExceptionInfo;
import cn.jaychang.scstudy.basems.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * <p>
 *  WebMvcConfig
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-16
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	private static final String CONTENT_TYPE_KEY = "Content-type";

	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 统一异常处理
	 * 注意：这里必须使用extendHandlerExceptionResolvers，不能是configureHandlerExceptionResolvers
	 * 若用configureHandlerExceptionResolvers，会覆盖所有异常处理器。导致调用方的feign无法进入到自定义的ErrorDecoder。
	 * 而是直接返回结果，不过结果的值都为null
	 *
	 * @param resolvers 异常处理器列表
	 */
	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add((request, response, handler, exception) -> {
			ExceptionInfo exceptionInfo = ExceptionInfo.builder().code(0).message(exception.getMessage())
					.exceptionClass(exception.getClass().getName()).build();
			responseResult(response, exceptionInfo);
			return new ModelAndView();
		});
	}

	private void responseResult(HttpServletResponse response, Object object) {
		response.setCharacterEncoding(DEFAULT_CHARSET);
		response.setHeader(CONTENT_TYPE_KEY, MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		try (PrintWriter pw = response.getWriter()) {
			pw.write(JsonUtils.toJsonString(object));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}

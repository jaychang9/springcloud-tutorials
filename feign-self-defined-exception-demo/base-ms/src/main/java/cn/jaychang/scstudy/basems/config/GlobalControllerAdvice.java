package cn.jaychang.scstudy.basems.config;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;

import cn.jaychang.scstudy.basems.exception.BusinessException;
import cn.jaychang.scstudy.basems.model.result.Result;
import cn.jaychang.scstudy.basems.model.result.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一处理异常
 * @author zhangjie
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		log.error("缺少请求参数:{}", e.getParameterName());
		return Result.<String>builder().code(ResultCode.MISSING_REQUEST_PARAMETER.code())
				.message(String.format("Required parameter %s is not present", e.getParameterName())).build();
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		log.error("参数解析失败:{}", e.getMessage(), e);
		return Result.builder().message(ResultCode.MALFORMED_REQUEST_PARAMETER.message()).build();
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.warn("参数验证失败:{}", e.getMessage(), e);
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		String field = error.getField();
		String defaultMessage = error.getDefaultMessage();
		String message = String.format("%s:%s", field, defaultMessage);
		return Result.builder().code(ResultCode.PARAMETER_NOT_VALID.code()).message(message).build();
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public Result handleBindException(BindException e) {
		log.warn("参数绑定失败:{}", e.getMessage(), e);
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		assert error != null;
		String field = error.getField();
		String defaultMessage = error.getDefaultMessage();
		String message = String.format("%s:%s", field, defaultMessage);
		return Result.builder().message(message).build();
	}



	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Result handleServiceException(ConstraintViolationException e) {
		log.warn("参数验证失败:{}", e.getMessage(), e);
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		ConstraintViolation<?> violation = violations.iterator().next();
		String message = violation.getMessage();
		return Result.builder().message("Parameter:" + message).build();
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public Result handleValidationException(ValidationException e) {
		log.warn("参数验证失败:{}", e.getMessage(), e);
		return Result.builder().message("Validation exception").build();
	}

	/**
	 * 404 - Not Found
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public Result handleNotFoundException(NoHandlerFoundException e) {
		log.error("请求的URL不存在", e);
		return Result.builder().code(ResultCode.NOT_FOUND.code())
				.message(String.format(ResultCode.NOT_FOUND.message(), e.getRequestURL())).build();
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		log.error("不支持当前请求方法:{}", e.getMessage(), e);
		return Result.builder().code(ResultCode.REQUEST_METHOD_NOT_SUPPORTED.code())
				.message(String.format(ResultCode.REQUEST_METHOD_NOT_SUPPORTED.message(),e.getMethod())).build();
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public Result handleHttpMediaTypeNotSupportedException(Exception e) {
		log.error("不支持当前媒体类型:{}", e.getMessage(), e);
		return Result.builder().code(ResultCode.CONTENT_TYPE_NOT_SUPPORTED.code())
				.message(ResultCode.CONTENT_TYPE_NOT_SUPPORTED.message()).build();
	}

	/**
	 * 200
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(BusinessException.class)
	public Result handleServiceException(BusinessException e) {
		log.warn("业务逻辑异常:{}", e.getMessage(), e);
		return Result.builder().code(ResultCode.BUSINESS_EXCEPTION.code())
				.message(String.format(ResultCode.BUSINESS_EXCEPTION.message(), e.getMessage())).build();
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		log.warn("通用异常:{}", e.getMessage(), e);
		return Result.builder().code(ResultCode.FAILURE.code()).message(e.getMessage()).build();
	}
}
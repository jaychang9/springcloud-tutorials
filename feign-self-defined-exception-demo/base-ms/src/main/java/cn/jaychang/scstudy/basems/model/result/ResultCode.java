package cn.jaychang.scstudy.basems.model.result;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * @author zhangjie
 * @date 2018/07/31
 */
public enum ResultCode {
	/** 系统繁忙(服务器内部错误)*/
	FAILURE(-1, "failure"),
	/** 请求成功*/
	SUCCESS(0, "success"),


	/** 请求异常（非业务）400开头*/

	/** 缺少请求参数*/
	MISSING_REQUEST_PARAMETER(400001, "Required parameter %s is not present"),

	/** 参数解析失败(非预期的请求参数,无法读取)*/
	MALFORMED_REQUEST_PARAMETER(400002, "Malformed json request"),

	/** 参数验证失败*/
	PARAMETER_NOT_VALID(400003, "Parameter is not valid"),

	/** 请求URL不存在*/
	NOT_FOUND(400004, "Request url[%s] not exists"),

	/** 不支持当前请求方法*/
	REQUEST_METHOD_NOT_SUPPORTED(400005, "Request method[%s] not supported"),

	/** 不支持当前媒体类型*/
	CONTENT_TYPE_NOT_SUPPORTED(400006, "ContentType not supported"),


	/** 服务内部异常（非业务）500开头   500001为通用业务异常*/
	BUSINESS_EXCEPTION(500001, "%s"),

	/** 认证鉴权异常（非业务相关）600开头*/

	/** Token已过期或失效*/
	TOKEN_EXPIRED(600001, "Token expired"),
	/** Token已失效*/
	TOEKN_INVALID(600002, "Token invalid"),
	/** 用户已经被禁用*/
	USER_DISABLED(600003, "User disabled"),
	/** 用户名不存在*/
	USERNAME_NOT_FOUND(600004, "Username not found"),
	/** 密码不正确*/
	PASSWORD_NOT_CORRECT(600005, "Password not correct");


	/** 业务异常（非业务相关，业务异常需要各个业务方自己定义）(401xxx-499xxx,501xxx-599xxx,601xxx-699xxx,700xxx-999xxx)*/

	private final int code;
	private final String message;

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}

	private static Map<Integer, ResultCode> CODE_MESSAGE_MAP;

	static {
		ResultCode[] resultCodes = ResultCode.values();
		CODE_MESSAGE_MAP = Arrays.stream(resultCodes)
				.collect(Collectors.toMap(ResultCode::code, (resultCode) -> resultCode));
	}

	public ResultCode getResultCode(int code) {
		return CODE_MESSAGE_MAP.get(code);
	}
}


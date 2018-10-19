package cn.jaychang.scstudy.basems.model.result;

/**
 * 响应结果生成工具
 *
 * @author zhangjie
 * @date 2017/11/02
 */
@SuppressWarnings("unused")
public class ResultGenerator {
	private ResultGenerator() {
	}

	public static Result genSuccessResult() {
		return Result.builder().code(ResultCode.SUCCESS.code()).message(ResultCode.SUCCESS.message()).build();
	}

	public static <T> Result<T> genSuccessResult(T data) {
		return Result.<T>builder().code(ResultCode.SUCCESS.code()).message(ResultCode.SUCCESS.message()).data(data)
				.build();
	}

	public static Result genFailResult() {
		return Result.builder().code(ResultCode.FAILURE.code()).message(ResultCode.FAILURE.message()).build();
	}

	public static Result genFailResult(String message) {
		return Result.builder().code(ResultCode.FAILURE.code()).message(message).build();
	}

	public static <T> Result<T> genFailResult(T data) {
		return Result.<T>builder().code(ResultCode.FAILURE.code()).message(ResultCode.FAILURE.message()).data(data)
				.build();
	}

	public static <T> Result<T> genFailResult(String message, T data) {
		return Result.<T>builder().code(ResultCode.FAILURE.code()).message(message).data(data).build();
	}
}

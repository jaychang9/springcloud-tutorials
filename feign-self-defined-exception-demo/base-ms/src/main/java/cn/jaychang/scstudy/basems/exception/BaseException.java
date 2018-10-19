package cn.jaychang.scstudy.basems.exception;

import java.io.Serializable;

/**
 *
 * <p>
 *  异常基础类(继承该异常的)
 * </p>
 *
 * @author zhangjie
 * @date 2018-10-16 10:30
 */
public class BaseException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 6670140702161650580L;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
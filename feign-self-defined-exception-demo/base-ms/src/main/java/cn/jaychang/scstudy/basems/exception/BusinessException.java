package cn.jaychang.scstudy.basems.exception;


/**
 *
 * <p>
 * 业务异常
 * </p>
 *
 * @author zhangjie
 * @date 2018-10-16 12:34
 */
public class BusinessException extends BaseException {

	public BusinessException(){super();}

	/**
	 * <p>
	 * 仅含错误信息的构造器
	 * </p>
	 *
	 * @param message 错误消息
	 */
	public BusinessException(String message) {
		super(message);
	}
}

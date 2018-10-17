package cn.jaychang.scstudy.aggregationms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 */
@Data
public class ExceptionDTO implements Serializable{
	private static final long serialVersionUID = -618648426912284593L;

	/** 异常编码*/
	private int code;

	/** 异常信息*/
	private String message;

	/** 异常类class全限定名*/
	private String exceptionClass;
}

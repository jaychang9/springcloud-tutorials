package cn.jaychang.scstudy.basems.model.result;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * <p>
 *  异常结果类(用于Feign ErrorDecode)
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-16
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionInfo implements Serializable {
	private static final long serialVersionUID = -618648426912284593L;

	/** 异常编码*/
	private int code;

	/** 异常信息*/
	private String message;

	/** 异常类class全限定名*/
	private String exceptionClass;

}

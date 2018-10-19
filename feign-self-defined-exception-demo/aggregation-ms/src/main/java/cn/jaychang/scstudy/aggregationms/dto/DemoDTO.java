package cn.jaychang.scstudy.aggregationms.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * <p>
 * DemoDTO
 * </p>
 *
 * @author zhangjie
 *
 * @date 2018-10-16 11:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DemoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String createDate;

}
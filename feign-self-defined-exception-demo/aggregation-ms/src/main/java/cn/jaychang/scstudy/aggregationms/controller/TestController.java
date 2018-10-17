package cn.jaychang.scstudy.aggregationms.controller;

import cn.jaychang.scstudy.aggregationms.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 *
 */
@RestController
@RequestMapping("agg")
public class TestController {

	@Autowired
	private BaseClient baseClient;

	@GetMapping("/hello1")
	public String hello1(String name){
		return baseClient.hello1(name);
	}


	@GetMapping("/hello2")
	public String hello2(String name){
		String string =  baseClient.hello2(name);
		return string;
	}
}

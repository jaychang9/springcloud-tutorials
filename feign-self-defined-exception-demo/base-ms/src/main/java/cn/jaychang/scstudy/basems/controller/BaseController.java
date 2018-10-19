package cn.jaychang.scstudy.basems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-10-17
 */
@RestController
@RequestMapping("/base")
public class BaseController {

	@GetMapping("/hello1")
	public String hello1(@RequestParam(name = "name",required = true) String name){
		return "hello"+name;
	}

	@GetMapping("/hello2")
	public String hello2(String name){
		int a = 1 / 0;
		return "hello"+name;
	}
}

package cn.jaychang.scstudy.aggregationms.controller;

import cn.jaychang.scstudy.aggregationms.client.BaseClient;
import cn.jaychang.scstudy.aggregationms.client.DemoClient;
import cn.jaychang.scstudy.aggregationms.dto.DemoDTO;
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
	@Autowired
	private DemoClient demoClient;

	@GetMapping("/hello1")
	public String hello1(String name){
		return baseClient.hello1(name);
	}


	@GetMapping("/hello2")
	public String hello2(String name){
		String string =  baseClient.hello2(name);
		return string;
	}

	@GetMapping("/demo1")
	public DemoDTO demo1(Long id){
		return demoClient.detail(id);
	}


	@GetMapping("/demo2")
	public DemoDTO demo2(Long id){
		return demoClient.mockDetailThrowException(id);
	}

}

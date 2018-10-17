package cn.jaychang.scstudy.basems.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjie
 * @package net.showcoo.gc.common.util
 * @description JSON工具类
 * @create 2018-08-01 09:53
 */
@Slf4j
public class JsonUtils {
    /** 线程安全*/
    private static final ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private JsonUtils(){

    }

    public static String toJsonString(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T toObject(String json,Class<T> clazz){
		try {
			return mapper.readValue(json,clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

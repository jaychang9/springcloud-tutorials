package cn.jaychang.scstudy.basems.model.result;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 统一API响应结果封装
 *
 * @author zhangjie
 * @since 2017/11/02
 */
@Data
@Builder
@AllArgsConstructor
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 4814611774349568918L;
    private int code;
    private String message;
    /** Not show the null field*/
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(int code){
        this.code = code;
    }

    public Result(int code,String message){
        this.code = code;
        this.message = message;
    }
}

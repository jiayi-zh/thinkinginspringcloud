package com.bat.jyzh.common.entity.resp;

import lombok.Data;

/**
 * 通用结构体
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:22
 **/
@Data
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult<?> buildCommonResult(Integer code, String msg) {
        CommonResult<?> result = new CommonResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
